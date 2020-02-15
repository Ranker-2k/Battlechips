package org.academiadecodigo.rhashtafaris.battlechip;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.CollisionDetector;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Grid;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Bullet;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Graphics;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Movable;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Tank;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game {

    private static final int DISTANCE = 20;
    private static final int DELAY = 20;

    private Tank player1;
    private Tank player2;


    private CollisionDetector collisionDetector;
    private KeyboardController keyboard;

    Game() {

        this.keyboard = new KeyboardController(this);

    }

    private void init() {

        this.keyboard.keyboardInit();

        Grid canvas = new Grid();
        this.collisionDetector = new CollisionDetector(this);

        player1 = new Tank(360, 1000, collisionDetector, Directions.LEFT, Graphics.PLAYER1);
        player2 = new Tank(360, 50, collisionDetector, Directions.RIGHT, Graphics.PLAYER2);

    }

    void start() {

        init();

        try {

            while (true) {

                Thread.sleep(DELAY);

                player1.bulletRefresh(DISTANCE);
                player2.bulletRefresh(DISTANCE);
                player1.movePosition(DISTANCE);
                player2.movePosition(DISTANCE);
                this.collisionDetector.checkCollisionsPlayer1();
                this.collisionDetector.checkCollisionsPlayer2();
            }

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public Tank getPlayer1() {
        return this.player1;
    }

    public Tank getPlayer2() {
        return this.player2;
    }

}
