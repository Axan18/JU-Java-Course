import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test7 {
	class MojaKostka implements KostkaDoGry {
		private final Random rand = new Random();

		@Override
		public int rzut() {
			return rand.nextInt(6) + 1;
		}
	}

	public static void main(String[] args) {
		Test7 test = new Test7();
		int numberOfSimulations = 6;

		LeniwyEksperymentator watkowyEksperymentator = new LeniwyEksperymentator();

		// Utwórz fabrykę wątków z pulą o stałym rozmiarze 5
		ExecutorService executorService = Executors.newFixedThreadPool(5);
	watkowyEksperymentator.fabrykaWatkow(executorService);
		CountDownLatch latch = new CountDownLatch(numberOfSimulations);

		for (int i = 0; i < numberOfSimulations; i++) {
			int id = watkowyEksperymentator.kostkaDoZbadania(test.new MojaKostka(), 100000000);
			System.out.println("Rozpoczęto badanie kostki o identyfikatorze: " + id);

			// Użyj metody submit zamiast execute
			executorService.submit(() -> {
				try {
					if (watkowyEksperymentator.badanieKostkiZakonczono(id)) {
						System.out.println("Zakończono badanie kostki o identyfikatorze: " + id);
					}
				} finally {
					latch.countDown(); // Zmniejsz licznik CountDownLatch nawet, jeśli coś pójdzie nie tak
				}
			});
		}

		try {
			latch.await(1, TimeUnit.MINUTES); // Oczekaj, aż wszystkie badania zostaną zakończone
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Po zakończeniu programu trzeba wyłączyć ExecutorService
			executorService.shutdown();
		}
	}
}
