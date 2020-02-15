package org.academiadecodigo.rhashtafaris.battlechip.Movables;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.CollisionDetector;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Grid;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;

public class Tank implements Movable {

    private int health;
    private Bullet[] bulletArray;
    private Position position;
    private boolean destroyed;
    private Directions currentDirection;
    private static final int MAX_AMMO = 10;

    public Tank(
            int posInitY,
            int posInitX,
            CollisionDetector collisionDetector,
            Directions direction, Graphics graphic) {

        position = new Position(posInitX, posInitY, direction, graphic);

        this.destroyed = false;
        this.currentDirection = Directions.STILL;

        this.bulletArray = new Bullet[MAX_AMMO];
        populateBulletArray();

        this.health = 300;

    }

    public Bullet[] getBulletArray() {
        return bulletArray;
    }

    public boolean isDestroyed() {
        return destroyed;
    }


    public void die () {
        if (health <= 0){
            this.destroyed = true;
            return;
        }
        this.destroyed = false;
    }


    private void populateBulletArray(){

        for (int i = 0; i < this.bulletArray.length; i++){
            this.bulletArray[i] = new Bullet(Grid.BORDER, Grid.BORDER,Directions.STILL);
        }
    }

    public void shoot() {

        for (int i = 0; i < bulletArray.length; i++) {
            if (bulletArray[i].isVisible()){
                continue;
            }
            bulletArray[i].resetPosition(this.position.getxWidth() + 20,this.position.getyHeight() + 20,this.position.getDirection());
            return;
        }
    }

    //updating visual representation of bullets;
    public void bulletRefresh(int distance) {

        for (int i = 0; i < this.getBulletArray().length; i++) {

            if (this.getBulletArray()[i] == null) {
                continue;
            }

            if (this.bulletArray[i].getPosition().hittingWall()) {
                this.bulletArray[i].getPosition().hide();
                this.bulletArray[i].goInvisible();
            }
            this.bulletArray[i].movePosition(distance);
        }
    }

    public void beHit(int damage) {
        this.health -= damage;
        System.out.println(health);
    }

    @Override
    public void changeDirection(Directions direction) {
        this.currentDirection = direction;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void movePosition(int distance) {

        this.position.movePosition(distance,currentDirection);
        this.currentDirection = Directions.STILL;
        this.position.convertPosition();
    }

}

