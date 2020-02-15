package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.rhashtafaris.battlechip.Game;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Bullet;

public class CollisionDetector {

    private Game game;

    public CollisionDetector(Game game) {
        this.game = game;
    }

    public void checkCollisionsPlayer1() {



        Bullet[] bulletArray = game.getPlayer2().getBulletArray();

        for (int i = 0; i < bulletArray.length; i++) {
            if (bulletArray[i] == null) {
                continue;
            }
            if (bulletArray[i].isVisible()) {
                bulletArray[i].checkHits(game.getPlayer2());
            }
        }
    }

    public void checkCollisionsPlayer2() {

        Bullet[] bulletArray = game.getPlayer1().getBulletArray();

        for (int i = 0; i < bulletArray.length; i++) {
            if (bulletArray[i] == null) {
                continue;
            }
            if (bulletArray[i].isVisible()) {
                bulletArray[i].checkHits(game.getPlayer1());
            }
        }
    }
}

