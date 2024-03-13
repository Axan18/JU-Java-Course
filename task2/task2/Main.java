import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TestowaKostkaDoGry kostka = new TestowaKostkaDoGry();
        WspanialyEksperymentator test = new WspanialyEksperymentator();
        test.czasJednegoEksperymentu(1000);
        test.użyjKostki(kostka);

        List<Integer> kolejnosc = new ArrayList<>();
        kolejnosc.add(4);
        kolejnosc.add(2);
        kolejnosc.add(5);

        Set<Integer> zbior = new HashSet<>();
        zbior.add(3);
        zbior.add(2);
        zbior.add(5);

        //System.out.println("szansa na wyrzucenie oczek: " + test.szansaNaWyrzucenieOczek(2));
        System.out.println("szansa na wyrzucenie kolejno: " + test.szansaNaWyrzucenieKolejno(kolejnosc));
       // System.out.println("szansa na wyrzucenie w dowolnej kolejnosci: " + test.szansaNaWyrzucenieWDowolnejKolejności(zbior));
    }
}