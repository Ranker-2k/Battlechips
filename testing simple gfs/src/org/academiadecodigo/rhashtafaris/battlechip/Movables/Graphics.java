package org.academiadecodigo.rhashtafaris.battlechip.Movables;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;

public enum Graphics {
    PLAYER1,
    PLAYER2,
    BULLET;

    public String getGraphic(Directions direction) {

        switch (this) {
            case PLAYER1:
                return graphP1(direction);
            case PLAYER2:
                return graphP2(direction);
            default:
                if (((int) (Math.random() * 2)) < 1) {
                    return graphBullet(direction, true); //1
                }
                return graphBullet(direction, false); //0
        }
    }

    private String graphP1(Directions directions) {
        switch (directions) {
            case UP:
                return "chip1up.png";
            case DOWN:
                return "chip1down.png";
            case LEFT:
                return "chip1left.png";
            default:
                return "chip1right.png";
        }
    }

    private String graphP2(Directions direction) {

        switch (direction) {
            case UP:
                return "chip2up.png";
            case DOWN:
                return "chip2down.png";
            case LEFT:
                return "chip2left.png";
            default:
                return "chip2right.png";
        }
    }

    private String graphBullet(Directions direction, boolean bit) {

        switch (direction) {
            case UP:
            case DOWN:
                return (bit) ? "bullet1UD.png" : "bullet0UD.png";
            default:
                return (bit) ? "bullet1LR.png" : "bullet0LR.png";
        }
    }
}
