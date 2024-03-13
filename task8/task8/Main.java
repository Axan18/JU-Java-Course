import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // Utwórz fabrykę wątków z pulą o stałym rozmiarze 5
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Utwórz obiekt LeniwyEksperymentator
        LeniwyEksperymentator leniwyEksperymentator = new LeniwyEksperymentator();

        // Ustaw fabrykę wątków
        leniwyEksperymentator.fabrykaWatkow(executorService);

        // Tworzymy obiekt kostki do gry
        TestowaKostkaDoGry kostka = new TestowaKostkaDoGry(); // Ustaw odpowiednią liczbę ścian kostki

        // Przeprowadzamy testy na wielu kostkach
        for (int i = 0; i < 10; i++) {
            int id = leniwyEksperymentator.kostkaDoZbadania(kostka, 100); // 100 rzutów dla każdej kostki
            System.out.println("Rozpoczęto badanie kostki o identyfikatorze: " + id);
        }

        // Czekamy, aż wszystkie badania zostaną zakończone
        while (true) {
            boolean wszystkieZakonczone = true;
            for (int i = 0; i < 10; i++) {
                if (!leniwyEksperymentator.badanieKostkiZakonczono(i)) {
                    wszystkieZakonczone = false;
                    break;
                }
            }

            if (wszystkieZakonczone) {
                break;
            }
        }

        // Pobieramy histogramy dla wszystkich identyfikatorów
        for (int i = 0; i < 10; i++) {
            Map<Integer, Integer> histogram = leniwyEksperymentator.histogram(i);
            System.out.println("Histogram dla kostki o identyfikatorze " + i + ": " + histogram);
        }
    }
}
