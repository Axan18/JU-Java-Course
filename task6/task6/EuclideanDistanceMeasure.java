public class EuclideanDistanceMeasure implements DistanceMeasure {

    @Override
    public double distance(Point a, Point b) {
        double deltaX = a.x() - b.x();
        double deltaY = a.y() - b.y();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
