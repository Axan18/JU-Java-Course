import java.util.ArrayList;

public class Indiana implements Explorer{
    Position start=new Position(0,0);
    Position next=new Position(0,0);
    Position forbiddenPosition=new Position(0,0);
    ArrayList<Position> forbidden = new ArrayList<>();
    ArrayList<Position> traveled = new ArrayList<>();
    PlayerController controller;
    int underwaterMoves;
    int underwaterMovesRetriever;
    Direction underWaterNext;
    int waterCounter=0;
    boolean isExit=false;
    boolean isUnderwater=false;
    boolean isGoingBackUnderwater=false;
    @Override
    public void underwaterMovesAllowed(int moves) {
        this.underwaterMoves=moves;
        this.underwaterMovesRetriever=moves;
    }

    @Override
    public void setPlayerController(PlayerController controller) {
        this.controller=controller;
    }

    @Override
    public void findExit() {
        pathFinder(start);
    }

    private boolean pathFinder(Position position)
    {
        boolean canGo = true;
        for(Direction direction : Direction.values())
        {
            Direction walkingDirection=direction;
            if(isExit)  return true;
            try{
                if(traveled.contains(direction.step(position)) || forbidden.contains(direction.step(position))) continue; //nie ide gdzie bylem albo nie można isc
                if(isUnderwater && !isGoingBackUnderwater) {
                    underwaterMoves--; // jak jestesmy pod wodą to nam sie zmniejsza ilosc ruchow
                    walkingDirection=underWaterNext; // idziemy w tym samym kierunku
                }
                if(isGoingBackUnderwater && waterCounter>0)
                {
                    walkingDirection=opposite(underWaterNext);
                }
                forbiddenPosition=walkingDirection.step(position); //potencjalne forbidden
                controller.move(walkingDirection); //idziemy w danym kierunku
                waterCounter=0;
                isGoingBackUnderwater=false;
                isUnderwater=false;
                underwaterMoves=underwaterMovesRetriever;// nie jestesmy w wodzie wiec mamy pelna ilosc ruchow
                next = walkingDirection.step(position); // Pobieramy pozycję w danym kierunku
                traveled.add(position); // Dodajemy pozycję do listy odwiedzonych
            }
            catch (Flooded e) {
                isUnderwater = true;
                waterCounter++;
                next = walkingDirection.step(position); // Pobieramy pozycję w danym kierunku
                underWaterNext = walkingDirection; //zapamietujemy kierunek w ktorym idziemy pod woda
                if(waterCounter <= underwaterMovesRetriever/2 ) //mamy oddechy, idziemy przez wode do przod
                {
                    traveled.add(position); // Dodajemy pozycję do listy odwiedzonych
                }
                else
                {
                        isGoingBackUnderwater=true;
                        try {
                            controller.move(opposite(walkingDirection)); // Cofamy się i w następnej iteracji próbujemy iść w innym kierunku
                        }catch(Exception ignore){}
                        waterCounter--;
                    return false;
                }
            }
            catch (Wall e) {
                forbidden.add(forbiddenPosition);
                continue;
            }
            catch (OnFire e) {
                forbidden.add(forbiddenPosition);
                traveled.remove(position);// Usuwamy ostatnią pozycję z listy odwiedzonych
                traveled.add(next);// Dodajemy pozycję do listy odwiedzonych
                next =position ;// Pobieramy pozycję w danym kierunku
                try {
                    controller.move(opposite(walkingDirection));// Cofamy się i w następnej iteracji próbujemy iść w innym kierunku
                }catch(Exception ignore){}
                continue;
            }
            catch (Exit e) {
                isExit = true;
                return true;
            }

                if(!isGoingBackUnderwater)canGo = pathFinder(next); // Sprawdzamy czy można iść dalej
//                else {
//                    canGo = false;
//                }
                if(canGo == false) //wracamy
                {
                    traveled.remove(position); // Usuwamy pozycję z ktorej przyszlismy z listy odwiedzonych;
                    traveled.add(next); // Dodajemy pozycję z ktorej sie cofamy do listy odwiedzonych
                    next = position; // Pobieramy pozycję w danym kierunku

                    try {
                        controller.move(opposite(walkingDirection)); // Cofamy się i w następnej iteracji próbujemy iść w innym kierunku
                    } catch (Exception ignore) {
                    }
                }
        }

        if(next.equals(position)) return false;
        return true;
    }
private Direction opposite(Direction direction) {
    return switch (direction) {
        case NORTH -> Direction.SOUTH;
        case SOUTH -> Direction.NORTH;
        case EAST -> Direction.WEST;
        case WEST -> Direction.EAST;
    };
}
}

