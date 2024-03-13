import java.util.Random;

public class TestowaKostkaDoGry implements KostkaDoGry {
    private Random random;

    public TestowaKostkaDoGry() {
        random = new Random();
    }

    @Override
    public int rzut() {
        // W symulowanej kostce wylosowana liczba oczek będzie od 1 do 6.
        return random.nextInt(6) + 1;
    }
}
