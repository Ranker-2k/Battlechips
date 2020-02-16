package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.rhashtafaris.battlechip.Game;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Bullet;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Tank;
import org.academiadecodigo.rhashtafaris.battlechip.Pickables.FreeMemory;
import org.academiadecodigo.rhashtafaris.battlechip.Pickables.Pickables;

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

    public void pickableCollisionCheck (Tank player1, Tank player2, FreeMemory pickable){

        if (pickable == null){
            return;
        }
        if (pickable.getPosition().equals(player1.getPosition())){

            System.out.println("1");
            player1.setMemory();
            pickable.goInvisible();
            game.resetCurrentPickable();
            player1.memoryRefresh();
            return;
        }

        if (pickable.getPosition().equals(player2.getPosition())){
            System.out.println("2");
            player2.setMemory();
            pickable.goInvisible();
            game.resetCurrentPickable();
            player2.memoryRefresh();
        }
    }
}

