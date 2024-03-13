import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class LeniwyEksperymentator implements LeniwyBadaczKostekDoGry {
    ExecutorService executorService;
    private Map<Integer, Map<Integer, Integer>> histogram = new ConcurrentHashMap<>();
    private Map<Integer, Map<Integer, Integer>> badania = new ConcurrentHashMap<>();
    private Map<Integer, Future<Map<Integer,Integer>>> futureMap = new ConcurrentHashMap<>();
    private int id = 0;
    private final Object lock = new Object();
    @Override
    public void fabrykaWatkow(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public int kostkaDoZbadania(KostkaDoGry kostka, int liczbaRzutow) {
        int currentId;
        synchronized (lock) {
            currentId = id++;
        }
        futureMap.put(currentId,executorService.submit(new MyCallable(kostka, liczbaRzutow, currentId)));
        return currentId;
    }

    @Override
    public boolean badanieKostkiZakonczono(int identyfikator) {
        return !badania.containsKey(identyfikator);
    }

    @Override
    public Map<Integer, Integer> histogram(int identyfikator) {
            try{
                histogram.put(identyfikator, futureMap.get(identyfikator).get());
            }catch (Exception e){
                e.printStackTrace();
            }
        return histogram.get(identyfikator);
    }

    private class MyCallable implements Callable<Map<Integer, Integer>> {
        private int throwNumber;
        private KostkaDoGry kostka;
        int id;
        HashMap<Integer, Integer> myMap = new HashMap<>();

        public MyCallable(KostkaDoGry kostka, int throwNumber, int id) {
            this.throwNumber = throwNumber;
            this.kostka = kostka;
            this.id = id;
        }
        @Override
        public Map<Integer, Integer> call() {
                badania.put(id, myMap);
            for (int i = 0; i < throwNumber; i++) {
                int result = kostka.rzut();
                myMap.put(result, myMap.getOrDefault(result, 0) + 1);
            }
                badania.remove(id);
            return myMap;
        }
    }
}
