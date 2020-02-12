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
    private CollisionDetector collisionDetector;
    private boolean destroyed;

    public Tank(
            int maxAmmo,
            int posInitY,
            int posInitX,
            CollisionDetector collisionDetector,
            Directions direction, Graphics graphic) {

        position = new Position(posInitX,posInitY,direction, graphic);

        this.ammo = new Bullet[maxAmmo];
        this.collisionDetector = collisionDetector;
        this.destroyed = false;

    }

    public Bullet[] getAmmo(){
        return ammo;
    }

    public void shoot() {


        for (int i = 0; i < ammo.length; i++) {
            if (ammo[i] == null) {
                ammo[i] = new Bullet(this.collisionDetector, this.position.getxWidth(), this.position.getyHeight(), this.position.getDirection());
                return;
            }
        }
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
    public Position getPosition() {
        return position;
    }
}

