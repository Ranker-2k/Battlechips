package org.academiadecodigo.rhashtafaris.battlechip.Pickables;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Grid;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FreeMemory implements Pickables {

    private Picture picture;
    private Position position;

    public FreeMemory(){
        this.position.setPos(randomXPosition(), randomYPosition());
        this.picture = new Picture(position.getxWidth(), position.getyHeight(), ".png");
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
        return (int) Math.floor(Math.random() * (Grid.getWidth() - 70) + 20);
    }

    @Override
    public int randomYPosition() {
        return (int) Math.floor(Math.random() * (Grid.getHeight() - 70) + 20);
    }
}
