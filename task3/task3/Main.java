import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        NumberStatistics ns = new NumberStatistics();
        Set<Position> jedynki = new HashSet<>();
        jedynki.add(new Position(1,5));
        jedynki.add(new Position(1,9));
        jedynki.add(new Position(3,7));
        jedynki.add(new Position(5,4));
        Set<Position> dwojki = new HashSet<>();
        dwojki.add(new Position(1,4));
        dwojki.add(new Position(9,1));
        dwojki.add(new Position(9,5));
        Set<Position> trojki = new HashSet<>();
        trojki.add(new Position(6,7));
        trojki.add(new Position(9,9));
        Set<Position> czworki = new HashSet<>();
        czworki.add(new Position(1,1));
        czworki.add(new Position(7,6));
        Map<Integer,Set<Position>> numbers = new HashMap<>();
        numbers.put(1,jedynki);
        numbers.put(2,dwojki);
        numbers.put(3,trojki);
        numbers.put(4,czworki);
        ns.addNumbers(numbers);
        ns.sideLength(9);
        System.out.println(ns.neighbours(new Position(2,1),13));
    }
}