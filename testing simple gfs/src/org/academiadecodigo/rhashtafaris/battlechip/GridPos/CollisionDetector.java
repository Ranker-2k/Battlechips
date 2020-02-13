package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.rhashtafaris.battlechip.Movables.Movable;

public class CollisionDetector {

    private Grid grid;
    private Movable[] movables;

    public CollisionDetector(Grid grid, Movable[] movables){
        this.grid = grid;
        this.movables = movables;
    }

    public boolean checkIfColision(){
        return false;

    }

}
