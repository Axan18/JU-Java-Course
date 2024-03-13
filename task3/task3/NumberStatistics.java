import java.util.*;

class NumberStatistics implements Statistics{
    Map<Position,Integer> matrixValues = new HashMap<>();
    private int size;

    @Override
    public void sideLength(int length) {
        this.size=length;
    }

    @Override
    public void addNumbers(Map<Integer, Set<Position>> numberPositions) {
        Set<Integer> keys = numberPositions.keySet();
        for(Integer key:keys)
        {
            for(Position position:numberPositions.get(key)) {
                matrixValues.put(position,key);
            }
        }
    }

    @Override
    public Map<Integer, Map<Integer, Integer>> neighbours(Position position, int maxDistanceSquared) {
        Map<Integer, Map<Integer, Integer>> result = new HashMap<>();
            for(Position pos:matrixValues.keySet())
            {
                double tempx1= Math.abs(pos.col()+size- position.col());
                int tempx2= Math.abs(pos.col()- position.col());
                int tempx3= Math.abs(pos.col()-size- position.col());
                int tempy1= Math.abs(pos.row()+size- position.row());
                int tempy2= Math.abs(pos.row()- position.row());
                int tempy3= Math.abs(pos.row()-size - position.row());
                int changedX = (int) Math.min(Math.min(tempx1,tempx2),tempx3);
                int changedY = (int) Math.min(Math.min(tempy1,tempy2),tempy3);
                changedY += position.row();
                changedX +=  position.col();
                int distanceSquared = ((changedX - position.col())*(changedX - position.col()) + (changedY - position.row())*(changedY - position.row()));
                if(distanceSquared<=maxDistanceSquared)
                {
                    if (result.containsKey(matrixValues.get(pos))) {
                        Map<Integer, Integer> distanceMap = result.get(matrixValues.get(pos));
                        distanceMap.put(distanceSquared, distanceMap.getOrDefault(distanceSquared, 0) + 1);
                    } else {
                        Map<Integer, Integer> distanceMap = new HashMap<>();
                        distanceMap.put(distanceSquared, 1);
                        result.put(matrixValues.get(pos), distanceMap);
                    }
                }
            }
        return result;
    }
}