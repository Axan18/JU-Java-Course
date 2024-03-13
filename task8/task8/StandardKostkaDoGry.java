import java.util.Random;

public class StandardKostkaDoGry implements KostkaDoGry {
    private final Random random = new Random();


    /**
     * Wykonanie pojedynczego rzutu kostką.
     *
     * @return liczba oczek od 1 do 6 włącznie
     */
    @Override
    public int rzut() {
        return random.nextInt(6) + 1;
    }
}
