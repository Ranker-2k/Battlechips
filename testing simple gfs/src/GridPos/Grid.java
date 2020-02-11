package GridPos;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private static final int BORDER = 10;
    private int width;
    private int height;
    Rectangle canvas;

    public Grid (int width, int height){

        this.height = height;
        this.width = width;

        canvas = new Rectangle(BORDER,BORDER,width,height);
        canvas.fill();
        canvas.setColor(Color.WHITE);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
