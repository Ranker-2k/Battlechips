package org.academiadecodigo.rhashtafaris.battlechip.Pickables;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;

public interface Pickables {

    int randomXPosition();
    int randomYPosition();
    Position getPosition();
    void goInvisible();
    void goVisible();
    boolean isVisible();
}
