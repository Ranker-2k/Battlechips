package org.academiadecodigo.rhashtafaris.battlechip.Pickables;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Grid;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FreeMemory implements Pickables {

    private Picture picture;
    private Position position;
    private static final int INITIAL_RANGE = 20;
    private static final int FINAL_RANGE = 70;

    public FreeMemory(){
        int x = randomXPosition();
        int y = randomYPosition();
        this.picture = new Picture(x, y, "bullet_H_2.png");
        this.position = new Position(x, y, null, null);
        show();
    }

    @Override
    public void show() {
        this.picture.draw();
    }

    @Override
    public void hide() {
        this.picture.delete();
    }

    @Override
    public int randomXPosition() {
        return (int) Math.floor(Math.random() * (Grid.getWidth() - FINAL_RANGE) + INITIAL_RANGE);
    }

    @Override
    public int randomYPosition() {
        return (int) Math.floor(Math.random() * (Grid.getHeight() - FINAL_RANGE) + INITIAL_RANGE);
    }
}
