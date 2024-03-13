import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tester {

    public static void main(String[] args) {
        // Tworzymy ExecutorService z pojedynczym wątkiem
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Tworzymy instancję LeniwyEksperymentator
        LeniwyBadaczKostekDoGry eksperymentator = new LeniwyEksperymentator();

        // Dostarczamy executorService do eksperymentatora
        eksperymentator.fabrykaWatkow(executorService);

        // Tworzymy kostkę
        KostkaDoGry kostka = new StandardKostkaDoGry();

        // Przeprowadzamy testy
        int identyfikator1 = eksperymentator.kostkaDoZbadania(kostka, 1000);
        int identyfikator2 = eksperymentator.kostkaDoZbadania(kostka, 207000);
        int identyfikator3 = eksperymentator.kostkaDoZbadania(kostka, 15800);
        int identyfikator4 = eksperymentator.kostkaDoZbadania(kostka, 19900);
        int identyfikator5 = eksperymentator.kostkaDoZbadania(kostka, 2000);
        int identyfikator6 = eksperymentator.kostkaDoZbadania(kostka, 4050);
        int identyfikator7 = eksperymentator.kostkaDoZbadania(kostka, 10777700);
        int identyfikator8 = eksperymentator.kostkaDoZbadania(kostka, 207700);
        int identyfikator9 = eksperymentator.kostkaDoZbadania(kostka, 1050);
        int identyfikator10 = eksperymentator.kostkaDoZbadania(kostka, 10000);
        int identyfikator11 = eksperymentator.kostkaDoZbadania(kostka, 2000);
        int identyfikator12 = eksperymentator.kostkaDoZbadania(kostka, 1500);

        // Czekamy na zakończenie badań
        czekajNaZakonczenie(executorService);

        // Sprawdzamy wyniki
        sprawdzWyniki(eksperymentator, identyfikator1);
        sprawdzWyniki(eksperymentator, identyfikator2);
        sprawdzWyniki(eksperymentator, identyfikator3);
        sprawdzWyniki(eksperymentator, identyfikator4);
        sprawdzWyniki(eksperymentator, identyfikator5);
        sprawdzWyniki(eksperymentator, identyfikator6);
        sprawdzWyniki(eksperymentator, identyfikator7);
        sprawdzWyniki(eksperymentator, identyfikator8);
        sprawdzWyniki(eksperymentator, identyfikator9);
        sprawdzWyniki(eksperymentator, identyfikator10);
        sprawdzWyniki(eksperymentator, identyfikator11);
        sprawdzWyniki(eksperymentator, identyfikator12);

        // Zamykamy ExecutorService
        executorService.shutdown();
    }

    private static void czekajNaZakonczenie(ExecutorService executorService) {
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sprawdzWyniki(LeniwyBadaczKostekDoGry eksperymentator, int identyfikator) {
        if (eksperymentator.badanieKostkiZakonczono(identyfikator)) {
            Map<Integer, Integer> histogram = eksperymentator.histogram(identyfikator);
            System.out.println("Wyniki dla identyfikatora " + identyfikator + ": " + histogram);
        } else {
            System.out.println("Badanie kostki o identyfikatorze " + identyfikator + " nie zostało jeszcze zakończone.");
        }
    }
}
