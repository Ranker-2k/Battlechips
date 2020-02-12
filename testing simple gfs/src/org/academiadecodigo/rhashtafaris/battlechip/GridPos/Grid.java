package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int BORDER = 10;
    private static int width;
    private static int height;
    private static Picture canvasIMG;

    public Grid (){
        canvasIMG = new Picture(0,0,"canvas.png") ;
        canvasIMG.draw();

    }

    public static int getWidth(){
        return canvasIMG.getWidth();
    }

    public static int getHeight(){
        return canvasIMG.getHeight();
    }
}
