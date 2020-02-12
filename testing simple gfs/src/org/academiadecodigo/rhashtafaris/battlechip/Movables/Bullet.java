package org.academiadecodigo.rhashtafaris.battlechip.Movables;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.CollisionDetector;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;

public class Bullet implements Movable {

    private int damage;
    private Position position;
    private CollisionDetector collisionDetector;


    public Bullet (CollisionDetector collisionDetector, int xWidth, int yHeigth, Directions directions){
        position = new Position(xWidth+20,yHeigth+20,directions,Graphics.BULLET);
    }

    @Override
    public void move(Directions direction, int distance) {

        position.movePosition(direction,distance);
    }

    @Override
    public Position getPosition() {
        return this.position;
    }
}
