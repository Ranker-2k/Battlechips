package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.rhashtafaris.battlechip.Game;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Bullet;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Tank;

public class CollisionDetector {

    private Game game;

    public CollisionDetector(Game game) {
        this.game = game;
    }

    public void collisionCheck(Tank player1, Tank player2) {

        for (Bullet bulletP2 : player2.getBulletArray()) {
            if (!bulletP2.isVisible()) {
                continue;
            }
            bulletP2.checkBulletHits(player1);
        }

        for (Bullet bulletP1: player1.getBulletArray()){
            if (!bulletP1.isVisible()){
                continue;
            }
            bulletP1.checkBulletHits(player2);
        }
    }

    public void tankCollisionCheck (Tank player1, Tank player2){

        if (player1.getPosition().equals(player2.getPosition())){
            player1.collideTank(player2);
        }
    }


}

