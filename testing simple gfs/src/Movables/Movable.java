package Movables;

import GridPos.Directions;
import GridPos.Position;

public interface Movable {



    void move(Directions direction,int distance);

    /**
     * sets a direction
     */
    void setDirection();

    /**
     * checks limits
     * @return
     */
    boolean isHittingLimits();
    void hide();
    void show();
    Position getPosition();

}
