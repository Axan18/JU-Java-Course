import java.util.HashSet;
import java.util.Set;


public class Controller implements PlayerController {
    Position currentPosition = new Position(4, 3);
    Set<Position> onFireSet = new HashSet<>();
    Set<Position> floodedSet = new HashSet<>();
    Set<Position> exitSet = new HashSet<>();
    Set<Position> wallSet = new HashSet<>();
    Set<Position> repeated = new HashSet<>();

    public void setAll() {
        wallSet.add(new Position(1, 16));
        wallSet.add(new Position(2, 16));
        wallSet.add(new Position(3, 16));
        wallSet.add(new Position(4, 16));
        wallSet.add(new Position(5, 16));
        wallSet.add(new Position(6, 16));
        wallSet.add(new Position(7, 16));
        wallSet.add(new Position(8, 16));
        wallSet.add(new Position(9, 16));
        wallSet.add(new Position(10, 16));
        wallSet.add(new Position(11, 16));
        wallSet.add(new Position(12, 16));
        wallSet.add(new Position(13, 16));
        wallSet.add(new Position(14, 16));
        wallSet.add(new Position(15, 16));
        wallSet.add(new Position(16, 16));
        wallSet.add(new Position(17, 16));
        wallSet.add(new Position(18, 16));
        wallSet.add(new Position(1, 15));
        floodedSet.add(new Position(2, 15)); ///////////////////////////////zmiana wzgledem oryginału
        floodedSet.add(new Position(3, 15));
//        wallSet.add(new Position(4, 15));
//        wallSet.add(new Position(5, 15));
//        wallSet.add(new Position(6, 15));
//        wallSet.add(new Position(7, 15));
//        wallSet.add(new Position(8, 15));
//        wallSet.add(new Position(9, 15));
//        wallSet.add(new Position(10, 15));
//        wallSet.add(new Position(11, 15));
//        wallSet.add(new Position(12, 15));
//        wallSet.add(new Position(13, 15));
//        wallSet.add(new Position(14, 15));
//        wallSet.add(new Position(15, 15));
//        wallSet.add(new Position(16, 15));
//        wallSet.add(new Position(17, 15));
        wallSet.add(new Position(18, 15));
        wallSet.add(new Position(1, 14));
        wallSet.add(new Position(2, 14));
        wallSet.add(new Position(3, 14));
        wallSet.add(new Position(4, 14));
        wallSet.add(new Position(5, 14));
        wallSet.add(new Position(6, 14));
        wallSet.add(new Position(7, 14));
        wallSet.add(new Position(8, 14));
        wallSet.add(new Position(9, 14));
        wallSet.add(new Position(10, 14));
//        wallSet.add(new Position(11, 14));
        wallSet.add(new Position(12, 14));
        wallSet.add(new Position(13, 14));
        wallSet.add(new Position(14, 14));
        wallSet.add(new Position(15, 14));
        wallSet.add(new Position(16, 14));
        wallSet.add(new Position(17, 14));
        wallSet.add(new Position(18, 14));
        wallSet.add(new Position(1, 13));
//        wallSet.add(new Position(2, 13));
//        wallSet.add(new Position(3, 13));
//        wallSet.add(new Position(4, 13));
//        wallSet.add(new Position(5, 13));
//        wallSet.add(new Position(6, 13));
//        wallSet.add(new Position(7, 13));
        wallSet.add(new Position(8, 13));
//        wallSet.add(new Position(9, 13));
//        wallSet.add(new Position(10, 13));
//        wallSet.add(new Position(11, 13));
//        wallSet.add(new Position(12, 13));
        wallSet.add(new Position(13, 13));
        wallSet.add(new Position(14, 13));
        wallSet.add(new Position(15, 13));
        wallSet.add(new Position(16, 13));
        wallSet.add(new Position(17, 13));
        wallSet.add(new Position(18, 13));
        wallSet.add(new Position(1, 12));
        wallSet.add(new Position(2, 12));
        wallSet.add(new Position(3, 12));
//        wallSet.add(new Position(4, 12));
        wallSet.add(new Position(5, 12));
        wallSet.add(new Position(6, 12));
//        wallSet.add(new Position(7, 12));
        wallSet.add(new Position(8, 12));
//        wallSet.add(new Position(9, 12));
        wallSet.add(new Position(10, 12));
        wallSet.add(new Position(11, 12));
        wallSet.add(new Position(12, 12));
        wallSet.add(new Position(13, 12));
        wallSet.add(new Position(14, 12));
        wallSet.add(new Position(15, 12));
//        wallSet.add(new Position(16, 12));
        wallSet.add(new Position(17, 12));
        wallSet.add(new Position(18, 12));
        wallSet.add(new Position(1, 11));
//        wallSet.add(new Position(2, 11));
//        wallSet.add(new Position(3, 11));
//        wallSet.add(new Position(4, 11));
//        wallSet.add(new Position(5, 11));
        wallSet.add(new Position(6, 11));
        //        wallSet.add(new Position(7, 11));
        wallSet.add(new Position(8, 11));
//        wallSet.add(new Position(9, 11));
//        wallSet.add(new Position(10, 11));
        wallSet.add(new Position(11, 11));
        wallSet.add(new Position(12, 11));
        wallSet.add(new Position(13, 11));
        wallSet.add(new Position(14, 11));
        wallSet.add(new Position(15, 11));
//        wallSet.add(new Position(16, 11));
        wallSet.add(new Position(17, 11));
        wallSet.add(new Position(18, 11));
        wallSet.add(new Position(1, 10));
//        wallSet.add(new Position(2, 10));
        wallSet.add(new Position(3, 10));
//        wallSet.add(new Position(4, 10));
//        wallSet.add(new Position(5, 10));
        wallSet.add(new Position(6, 10));
        wallSet.add(new Position(7, 10));
//        wallSet.add(new Position(8, 10));
//        wallSet.add(new Position(9, 10));
//        wallSet.add(new Position(10, 10));
//        wallSet.add(new Position(11, 10));
//        wallSet.add(new Position(12, 10));
//        wallSet.add(new Position(13, 10));
//        wallSet.add(new Position(14, 10));
        wallSet.add(new Position(15, 10));
//        wallSet.add(new Position(16, 10));
        wallSet.add(new Position(17, 10));
        wallSet.add(new Position(18, 10));
        wallSet.add(new Position(1, 9));
//        wallSet.add(new Position(2, 9));
        wallSet.add(new Position(3, 9));
//        wallSet.add(new Position(4, 9));
//        wallSet.add(new Position(5, 9));
        wallSet.add(new Position(6, 9));
        wallSet.add(new Position(7, 9));
        wallSet.add(new Position(8, 9));
//        wallSet.add(new Position(9, 9));
//        wallSet.add(new Position(10, 9));
//        wallSet.add(new Position(11, 9));
        wallSet.add(new Position(12, 9));
        onFireSet.add(new Position(13, 9));
//        wallSet.add(new Position(14, 9));
        wallSet.add(new Position(15, 9));
//        wallSet.add(new Position(16, 9));
        wallSet.add(new Position(17, 9));
        wallSet.add(new Position(18, 9));
        wallSet.add(new Position(1, 8));
        floodedSet.add(new Position(2, 8));
        wallSet.add(new Position(3, 8));
//        wallSet.add(new Position(4, 8));
//        wallSet.add(new Position(5, 8));
//        wallSet.add(new Position(6, 8));
//        wallSet.add(new Position(7, 8));
//        wallSet.add(new Position(8, 8));
//        wallSet.add(new Position(9, 8));
//        wallSet.add(new Position(10, 8));
//        wallSet.add(new Position(11, 8));
        wallSet.add(new Position(12, 8));
        onFireSet.add(new Position(13, 8));
//        wallSet.add(new Position(14, 8));
        wallSet.add(new Position(15, 8));
//        wallSet.add(new Position(16, 8));
        wallSet.add(new Position(17, 8));
        wallSet.add(new Position(18, 8));
        wallSet.add(new Position(1, 7));
        floodedSet.add(new Position(2, 7));
        wallSet.add(new Position(3, 7));
//        wallSet.add(new Position(4, 7));
        wallSet.add(new Position(5, 7));
        wallSet.add(new Position(6, 7));
//        wallSet.add(new Position(7, 7));
//        wallSet.add(new Position(8, 7));
//        wallSet.add(new Position(9, 7));
        wallSet.add(new Position(10, 7));
//        wallSet.add(new Position(11, 7));
        wallSet.add(new Position(12, 7));
        wallSet.add(new Position(13, 7));
        wallSet.add(new Position(14, 7));
        wallSet.add(new Position(15, 7));
//        wallSet.add(new Position(16, 7));
        wallSet.add(new Position(17, 7));
        wallSet.add(new Position(18, 7));
        wallSet.add(new Position(1, 6));
//        wallSet.add(new Position(2, 6));
        wallSet.add(new Position(3, 6));
//        wallSet.add(new Position(4, 6));
        wallSet.add(new Position(5, 6));
        wallSet.add(new Position(6, 6));
//        wallSet.add(new Position(7, 6));
//        wallSet.add(new Position(8, 6));
//        wallSet.add(new Position(9, 6));
        wallSet.add(new Position(10, 6));
//        wallSet.add(new Position(11, 6));
        wallSet.add(new Position(12, 6));
        wallSet.add(new Position(13, 6));
        wallSet.add(new Position(14, 6));
        wallSet.add(new Position(15, 6));
//        wallSet.add(new Position(16, 10));
        wallSet.add(new Position(17, 6));
        wallSet.add(new Position(18, 6));
        wallSet.add(new Position(1, 5));
//        wallSet.add(new Position(2, 5));
//        wallSet.add(new Position(3, 5));
//        wallSet.add(new Position(4, 5));
        wallSet.add(new Position(5, 5));
//        wallSet.add(new Position(6, 5));
//        wallSet.add(new Position(7, 5));
//        wallSet.add(new Position(8, 5));
//        wallSet.add(new Position(9, 5));
//        wallSet.add(new Position(10, 5));
//        wallSet.add(new Position(11, 5));
        wallSet.add(new Position(12, 5));
        wallSet.add(new Position(13, 5));
//        wallSet.add(new Position(14, 5));
//        wallSet.add(new Position(15, 5));
//        wallSet.add(new Position(16, 5));
        wallSet.add(new Position(17, 5));
        wallSet.add(new Position(18, 5));
        wallSet.add(new Position(1, 4));
//        wallSet.add(new Position(2, 4));
        wallSet.add(new Position(3, 4));
//        wallSet.add(new Position(4, 4));
        wallSet.add(new Position(5, 4));
//        wallSet.add(new Position(6, 4));
//        wallSet.add(new Position(7, 4));
        wallSet.add(new Position(8, 4));
//        wallSet.add(new Position(9, 4));
 //       wallSet.add(new Position(10, 4));
        wallSet.add(new Position(11, 4));
        wallSet.add(new Position(12, 4));
//        wallSet.add(new Position(13, 4));
//        wallSet.add(new Position(14, 4));
        onFireSet.add(new Position(15, 4));
        wallSet.add(new Position(16, 4));
        wallSet.add(new Position(17, 4));
        wallSet.add(new Position(1, 3));
//        wallSet.add(new Position(2, 3));
        wallSet.add(new Position(3, 3));
//        wallSet.add(new Position(4, 3));
        wallSet.add(new Position(5, 3));
//        wallSet.add(new Position(6, 3));
//        wallSet.add(new Position(7, 3));
//        wallSet.add(new Position(8, 3));
        wallSet.add(new Position(9, 3));
//        wallSet.add(new Position(10, 3));
        wallSet.add(new Position(11, 3));
        wallSet.add(new Position(12, 3));
        wallSet.add(new Position(13, 3));
//        wallSet.add(new Position(14, 3));
        wallSet.add(new Position(15, 3));
        wallSet.add(new Position(16, 3));
        wallSet.add(new Position(17, 3));
        wallSet.add(new Position(18, 3));
        wallSet.add(new Position(1, 2));
        wallSet.add(new Position(2, 2));
        wallSet.add(new Position(3, 2));
//        wallSet.add(new Position(4, 2));
        wallSet.add(new Position(5, 2));
        wallSet.add(new Position(6, 2));
//        wallSet.add(new Position(7, 2));
//        wallSet.add(new Position(8, 2));
        wallSet.add(new Position(9, 2));
//        wallSet.add(new Position(10, 2));
//        wallSet.add(new Position(11, 2));
//        wallSet.add(new Position(12, 2));
//        wallSet.add(new Position(13, 2));
//        wallSet.add(new Position(14, 2));
//        wallSet.add(new Position(15, 2));
//        wallSet.add(new Position(16, 2));
//        wallSet.add(new Position(17, 2));
        wallSet.add(new Position(18, 2));
        wallSet.add(new Position(1, 1));
        wallSet.add(new Position(2, 1));
        wallSet.add(new Position(3, 1));
        exitSet.add(new Position(4, 1));
        wallSet.add(new Position(5, 1));
        wallSet.add(new Position(6, 1));
        wallSet.add(new Position(7, 1));
        wallSet.add(new Position(8, 1));
        wallSet.add(new Position(9, 1));
        wallSet.add(new Position(10, 1));
        wallSet.add(new Position(11, 1));
        wallSet.add(new Position(12, 1));
        wallSet.add(new Position(13, 1));
        wallSet.add(new Position(14, 1));
        wallSet.add(new Position(15, 1));
        wallSet.add(new Position(16, 1));
        wallSet.add(new Position(17, 1));
        wallSet.add(new Position(18, 1));

    }

    @Override
    public void move(Direction direction) throws OnFire, Flooded, Wall, Exit {
//        System.out.println("current pozycja" + currentPosition);
        Position futurePosition = direction.step(currentPosition);
        if (repeated.contains(futurePosition)) {
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        }
        System.out.println(currentPosition);
        if (onFireSet.contains(futurePosition)) {
            currentPosition = futurePosition;
            throw new OnFire();
        }
        //
        if (floodedSet.contains(futurePosition)) {
            currentPosition = futurePosition;
            System.out.println("WODAAAAAAAAAAAAAAAAAAAWODAAAAAAAAAAAAA");
            throw new Flooded();
        }
        if (exitSet.contains(futurePosition)) {
            currentPosition = futurePosition;
            System.out.println("ZNALEZIONEEEEEEEEEEEEEEEEEEEEEEEEE!");
            throw new Exit();
        }
        //brak zmiany pozycji kontrolera
        if (wallSet.contains(futurePosition)) {
            System.out.println("ściana!");
            repeated.add(futurePosition);
            throw new Wall();
        }
        System.out.println("ruszamy się!");
        currentPosition = futurePosition;
//        System.out.println("future pozycja" + futurePosition);
    }
}
