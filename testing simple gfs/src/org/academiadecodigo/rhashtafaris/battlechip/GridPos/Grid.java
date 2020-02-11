package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int BORDER = 10;
    private static int width;
    private static int height;
    private Rectangle canvas;

    public Grid (int width, int height){

        this.height = height;
        this.width = width;

        canvas = new Rectangle(BORDER,BORDER,width,height);
        canvas.fill();
        canvas.setColor(Color.WHITE);
    }

    public static int getWidth(){
        return width;
    }

    public static int getHeight(){
        return height;
    }
}
