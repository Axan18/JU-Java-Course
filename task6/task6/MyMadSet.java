import java.util.*;

public class MyMadSet implements MadSet{
    DistanceMeasure measure;
    double minAllowed;
    List<Point> points = new ArrayList<>();

    @Override
    public void setDistanceMeasure(DistanceMeasure measure) throws TooCloseException {
        this.measure = measure;
        boolean isRemoved = false;
        List<Point> removedPoints = new ArrayList<>();
        List<Point> pointsToRemove = new ArrayList<>();
        ListIterator<Point> iteratorA = points.listIterator();
        for (int i = 0; i < points.size(); i++) {
            Point pointA = points.get(i);
            if (pointsToRemove.contains(pointA)) continue;
            for (int j = i + 1; j < points.size(); j++) {
                Point pointB = points.get(j);
                if (pointsToRemove.contains(pointB)) continue;

                double distance = measure.distance(pointA, pointB);
                if (distance <= minAllowed) {
                    removedPoints.add(pointA);
                    removedPoints.add(pointB);
                    pointsToRemove.add(pointB);
                    pointsToRemove.add(pointA);
                    isRemoved = true;
                    break;
                }
            }
        }
        if(isRemoved) {
            pointsToRemove.forEach(points::remove);
        }
        if (!removedPoints.isEmpty()) {
            throw new TooCloseException(removedPoints);
        }
    }

    @Override
    public void setMinDistanceAllowed(double minAllowed) throws TooCloseException {
        this.minAllowed = minAllowed;
        boolean isRemoved = false;
        List<Point> removedPoints = new ArrayList<>();
        List<Point> pointsToRemove = new ArrayList<>();
        ListIterator<Point> iteratorA = points.listIterator();
        for (int i = 0; i < points.size(); i++) {
            Point pointA = points.get(i);
            if (pointsToRemove.contains(pointA)) continue;
            for (int j = i + 1; j < points.size(); j++) {
                Point pointB = points.get(j);
                if (pointsToRemove.contains(pointB)) continue;
                double distance = measure.distance(pointA, pointB);
                if (distance <= minAllowed) {
                    removedPoints.add(pointA);
                    removedPoints.add(pointB);
                    pointsToRemove.add(pointB);
                    pointsToRemove.add(pointA);
                    isRemoved = true;
                    break;
                }
            }
        }
        if(isRemoved) {
            pointsToRemove.forEach(points::remove);
        }
        if (!removedPoints.isEmpty()) {
            throw new TooCloseException(removedPoints);
        }
    }

    @Override
    public void addPoint(Point point) throws TooCloseException {
        boolean isRemoved = false;
        List<Point> removedPoints = new ArrayList<>();
        ListIterator<Point> iterator = points.listIterator();
        while(iterator.hasNext()){
            Point p = iterator.next();
            if(measure.distance(p, point) <= minAllowed){
                isRemoved = true;
                iterator.remove();
                removedPoints.add(p);
            }
        }
        if(isRemoved) {
            removedPoints.add(point);
            throw new TooCloseException(removedPoints);
        }
        else points.add(point);
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public List<Point> getSortedPoints(Point referencePoint) {
        List<Point> sortedPoints = new ArrayList<>(points);
        Collections.sort(sortedPoints, distanceComparator(referencePoint));
        return sortedPoints;
    }

    private Comparator<Point> distanceComparator(Point referencePoint) {
        return Comparator.comparingDouble(point -> measure.distance(referencePoint, point));
    }

}
