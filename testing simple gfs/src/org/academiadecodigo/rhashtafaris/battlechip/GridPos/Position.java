package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.rhashtafaris.battlechip.Movables.Graphics;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Position {

    private int xWidth;
    private int yHeight;
    private Picture graphic;
    private Directions direction;
    private Graphics graphicType;

    public Position(int x, int y,Directions initialDirection, Graphics graphicType) {
        this.xWidth = x;
        this.yHeight = y;
        this.graphicType = graphicType;
        this.direction = initialDirection;
        this.graphic = new Picture(xWidth,yHeight, this.graphicType.getGraphic(this.direction));
        this.graphic.draw();
    }

    private void show(Directions direction) {
        graphic.load(graphicType.getGraphic(direction));
        graphic.draw();
    }

    private void hide(){
    }

    public int getxWidth() {
        return xWidth;
    }

    public Directions getDirection(){
        return direction;
    }

    public int getyHeight() {
        return yHeight;
    }

    public void setPos(int x, int y) {
        this.xWidth = x;
        this.yHeight = y;
    }

    /**
     * visual position
     */
    public void convertPosition() {
        int transX = xWidth - graphic.getX();
        int transY = yHeight - graphic.getY();

        show(this.direction);
        graphic.translate(transX, transY);
    }

    /**
     * logical position
     */
    public void movePosition(Directions direction, int distance) {

        switch (direction) {
            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            default:
                moveRight(distance);
                break;
        }
    }

    private void moveUp(int distance) {
        this.direction = Directions.UP;

        if (yHeight - distance < Grid.BORDER) {
            setPos(getxWidth(), Grid.BORDER);
            return;
        }
        setMove(0, -distance);
    }

    private void moveDown(int distance) {
        this.direction = Directions.DOWN;

        if (yHeight + distance >= Grid.getHeight() - Grid.BORDER - this.graphic.getHeight()) {
            setPos(getxWidth(), Grid.getHeight() - Grid.BORDER - this.graphic.getHeight());
            return;
        }
        setMove(0, distance);
    }

    private void moveLeft(int distance) {
        this.direction = Directions.LEFT;

        if (xWidth - distance < Grid.BORDER) {
            setPos(Grid.BORDER, getyHeight());
            return;
        }
        setMove(-distance, 0);
    }

    private void moveRight(int distance) {
        this.direction = Directions.RIGHT;

        if (xWidth + distance >= Grid.getWidth() - Grid.BORDER - this.graphic.getWidth()) {
            setPos(Grid.getWidth() - Grid.BORDER - this.graphic.getWidth(), getyHeight());
            return;
        }
        setMove(distance, 0);
    }

    private void setMove(int distanceX, int distanceY) {
        this.xWidth += distanceX;
        this.yHeight += distanceY;
    }

    public boolean equals(Movable movable) {
        return false;
    }

}
