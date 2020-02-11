package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.rhashtafaris.battlechip.Movables.Movable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Position {

    private int xWidth;
    private int yHeight;
    private Rectangle tankRectangle;

    public Position(int x, int y){
       this.xWidth = x;
       this.yHeight = y;

       spawn();
    }

    private void spawn(){
        tankRectangle = new Rectangle(xWidth,yHeight,50,50);

        tankRectangle.setColor(Color.BLUE);
        tankRectangle.draw();
        tankRectangle.fill();
    }

    public int getxWidth(){
        return xWidth;
    }

    public int getyHeight(){
        return yHeight;
    }
    public void setPos(int x, int y){
        this.xWidth = x;
        this.yHeight = y;
    }

    /**
     * visual position
     */
    public void convertPosition(){

        int transX = xWidth - tankRectangle.getX();
        int transY = yHeight - tankRectangle.getY();
        tankRectangle.translate(transX,transY);

    }

    /**
     * logical position
     * @param distanceX
     * @param distanceY
     */
    public void movePosition (Directions direction, int distance){

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

    private void moveUp(int distance){
        if (yHeight - distance < Grid.BORDER){
            setPos(getxWidth(),Grid.BORDER);
            return;
        }
        theMove(0, -distance);
    }

    private void moveDown(int distance){
        if (yHeight + distance >= Grid.getHeight() - Grid.BORDER){
            setPos(getxWidth(),Grid.getHeight() - Grid.BORDER);
            return;
        }
        theMove(0, distance);
    }

    private void moveLeft(int distance){
        if (xWidth - distance < Grid.BORDER){
            setPos(Grid.BORDER,getyHeight());
            return;
        }
        theMove(-distance, 0);
    }

    private void moveRight(int distance){
        if (xWidth + distance >= Grid.getWidth() - Grid.BORDER){
            setPos(Grid.getWidth() - Grid.BORDER,getyHeight());
            return;
        }
        theMove(distance, 0);
    }

    private void theMove(int distanceX, int distanceY){
        this.xWidth += distanceX;
        this.yHeight += distanceY;
    }




    public boolean equals(Movable movable){
        return false;
    }
}
