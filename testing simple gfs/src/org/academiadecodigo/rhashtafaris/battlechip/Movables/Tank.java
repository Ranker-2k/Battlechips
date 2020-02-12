package org.academiadecodigo.rhashtafaris.battlechip.Movables;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.CollisionDetector;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Tank implements Movable {

    private int health;
    private Bullet[] ammo;
    private Position position;
    private Directions direction;
    private CollisionDetector collisionDetector;
    private boolean destroyed;

    public Tank(
            int maxAmmo,
            int posInitY,
            int posInitX,
            CollisionDetector collisionDetector) {

        position = new Position(posInitX,posInitY);

        this.ammo = new Bullet[maxAmmo];
        this.collisionDetector = collisionDetector;
        this.destroyed = false;

    }

    public void shoot() {

    }

    public void beHit(int damage) {


    }

    public boolean isDestroyed() {
        return destroyed;
    }


    @Override
    public void move(Directions direction, int distance) {
        position.movePosition(direction,distance);
    }

    @Override
    public void setDirection() {

    }

    @Override
    public boolean isHittingLimits() {
        return false;
    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }

    @Override
    public Position getPosition() {
        return position;
    }
}

