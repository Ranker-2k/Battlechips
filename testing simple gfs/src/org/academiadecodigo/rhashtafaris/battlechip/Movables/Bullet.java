package org.academiadecodigo.rhashtafaris.battlechip.Movables;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.CollisionDetector;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;

public class Bullet implements Movable {

    private static final int DAMAGE = 50;
    private Position position;
    private Directions currentDirection;
    private boolean visible;


    Bullet(int xWidth, int yHeigth, Directions directions) {

        position = new Position(xWidth + 20, yHeigth + 20, directions, Graphics.BULLET);
        this.currentDirection = directions;
        this.visible = false;
        this.position.hide();
    }

    @Override
    public void changeDirection(Directions direction) {

        this.currentDirection = direction;
    }

    public void goInvisible() {
        this.visible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    public void resetPosition(int x, int y, Directions directions) {
        position.setPos(x, y);
        position.setGraphicDirection(directions);

        currentDirection = directions;
        visible = true;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void movePosition(int distance) {

        if (visible) {
            this.position.movePosition(distance, currentDirection);
            this.position.convertPosition();
        }
    }


    public void checkHits (Tank tank){

        if (this.position.equals(tank.getPosition())){
            this.goInvisible();
            tank.beHit(DAMAGE);
        }
    }

    //REVIEW!
    /*
    private boolean hittingMovable(Tank tank) {

        return (this.getPosition().getxWidth() >= tank.getPosition().getxWidth() &&
                this.getPosition().getxWidth() <= tank.getPosition().getxWidth() + 28 &&
                this.getPosition().getyHeight() >= tank.getPosition().getyHeight() &&
                this.getPosition().getyHeight() <= tank.getPosition().getyHeight() + 28);
    }



    public void hit(Tank tank) {

        if (hittingMovable(tank)) {
            tank.beHit(this.damage);
        }
    }
    */
}
