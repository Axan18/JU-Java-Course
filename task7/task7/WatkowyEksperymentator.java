import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WatkowyEksperymentator implements BadaczKostekDoGry {
    private int limit;
    private ThreadFactory factory;
    private Map<Integer, Map<Integer, Integer>> histogram = new HashMap<>();
    private Map<Integer, Map<Integer, Integer>> badania = new HashMap<>();
    private final Object lock = new Object();
    private final Object lock2 = new Object();
    private int id = 0;
    private ArrayList<Thread> threads;

    @Override
    public void dozwolonaLiczbaDzialajacychWatkow(int limitWatkow) {
        this.limit = limitWatkow;
        threads = new ArrayList<>(limit);
    }

    @Override
    public void fabrykaWatkow(ThreadFactory fabryka) {
        this.factory = fabryka;
    }
    @Override
    public int kostkaDoZbadania(KostkaDoGry kostka, int liczbaRzutow) {
        int currentId;
        synchronized (lock2) {
            currentId = id++;
        }
        Thread thread = factory.getThread(new MyRunnable(kostka, liczbaRzutow, currentId));
        synchronized (lock) {
            if (threads.size() == limit) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            threads.add(thread);
        }
        thread.start();
        return currentId;
    }

    @Override
    public boolean badanieKostkiZakonczono(int identyfikator) {
            return !badania.containsKey(identyfikator);
    }

    @Override
    public Map<Integer, Integer> histogram(int identyfikator) {
            return histogram.get(identyfikator);
    }

    private class MyRunnable implements Runnable {
        private int throwNumber;
        private KostkaDoGry kostka;
        int id;
        HashMap<Integer, Integer> myMap = new HashMap<>();

        MyRunnable(KostkaDoGry kostka, int throwNumber, int id) {
            this.kostka = kostka;
            this.throwNumber = throwNumber;
            this.id = id;
        }

        @Override
        public void run() {
            synchronized(lock)
            {
                badania.put(id, myMap);
            }
            for (int i = 0; i < throwNumber; i++) {
                int result = kostka.rzut();
                myMap.put(result, myMap.getOrDefault(result, 0) + 1);
            }
            synchronized (lock) {
                histogram.put(id, myMap);
                badania.remove(id);
                threads.remove(Thread.currentThread());
                lock.notify();
            }
        }
    }
}
