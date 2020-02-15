package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int BORDER = 10;
    private static Picture canvas;

    public Grid (){

        canvas = new Picture(0,0,"canvas.png") ;
        canvas.draw();

    }

    public static int getWidth(){
        return canvas.getWidth();
    }

    public static int getHeight(){
        return canvas.getHeight();
    }
}
