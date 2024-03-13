import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tworzenie instancji MyMadSet
        MyMadSet pointManager = new MyMadSet();

        // Ustawianie minimalnej odległości
        try {
            pointManager.setMinDistanceAllowed(2.0);
        } catch (TooCloseException e) {
            System.out.println(e.removePoints());
        }

        // Ustawianie sposobu mierzenia odległości
        DistanceMeasure measure = new EuclideanDistanceMeasure(); // Przykładowy sposób mierzenia odległości
        try {
            pointManager.setDistanceMeasure(measure);
        } catch (TooCloseException e) {
            System.out.println("Nie można ustawić sposobu mierzenia odległości. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }

        // Dodawanie punktów
        try {
            pointManager.addPoint(new Point(1, 1));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }
        try {
            pointManager.addPoint(new Point(1.2, 1.2));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }
        try {
            pointManager.addPoint(new Point(1.2, 1.2));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }
        try {
            pointManager.addPoint(new Point(1.4, 1.2));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }
        try {
            pointManager.addPoint(new Point(2, 2));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }

        try {
            pointManager.addPoint(new Point(5, 5));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }
        try {
            pointManager.addPoint(new Point(3, 3));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }
        try {
            pointManager.addPoint(new Point(4, 4));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }
        try {
            pointManager.addPoint(new Point(1, 1));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }
        try {
            pointManager.addPoint(new Point(5, 1));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }
        try {
            pointManager.addPoint(new Point(3, 1));
        } catch (TooCloseException e) {
            System.out.println("Nie można dodać punktu. Punkty za blisko siebie:");
            System.out.println(e.removePoints());
        }

        // Pobieranie posortowanych punktów
        List<Point> sortedPoints = pointManager.getSortedPoints(new Point(0, 0));

        // Wyświetlanie posortowanych punktów
        System.out.println("Posortowane punkty:");
        for (Point sortedPoint : sortedPoints) {
            System.out.println(sortedPoint);
        }
    }
}