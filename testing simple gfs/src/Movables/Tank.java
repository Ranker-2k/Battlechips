package Movables;

import GridPos.CollisionDetector;
import GridPos.Directions;
import GridPos.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Tank implements Movable {

    private int health;
    private Rectangle rectangle;
    private Color color;
    private int size;
    private Bullet[] ammo;
    private Position position;
    private Directions direction;
    private CollisionDetector collisionDetector;
    private boolean destroyed;

    public Tank(
            Color color,
            int size,
            int maxAmmo,
            int posInitY,
            int posInitX,
            CollisionDetector collisionDetector
    ){

        this.color = color;
        this.size = size;
        this.ammo = new Bullet[maxAmmo];
        this.collisionDetector = collisionDetector;
        this.position = new Position(posInitX,posInitY);
        this.destroyed = false;

        rectangle = new Rectangle(posInitX,posInitY,size,size);
        rectangle.setColor(this.color);
        rectangle.draw();
        rectangle.fill();

    }

    public void shoot(){

    }

    public void beHit(int damage){

    }

    public boolean isDestroyed(){
        return destroyed;
    }


    @Override
    public void move(Directions direction, int distance) {

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
        return null;
    }
}

