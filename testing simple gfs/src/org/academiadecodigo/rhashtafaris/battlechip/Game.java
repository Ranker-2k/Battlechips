package org.academiadecodigo.rhashtafaris.battlechip;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.CollisionDetector;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Grid;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Bullet;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Graphics;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Movable;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Tank;
import org.academiadecodigo.rhashtafaris.battlechip.Pickables.FreeMemory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private static final int DISTANCE = 20;
    private static final int DELAY = 20;

    private Tank player1;
    private Tank player2;

    private Sound music;


    private CollisionDetector collisionDetector;
    private KeyboardController keyboard;

    Game() {

        this.keyboard = new KeyboardController(this);

    }

    private void init() {

        Grid canvas = new Grid();
        this.collisionDetector = new CollisionDetector(this);
        this.keyboard.keyboardInit();
        music = new Sound(" Resources/sfx/gameTheme.wav");

        player1 = new Tank(350, 915, Directions.LEFT, Graphics.PLAYER1, "player1");
        player2 = new Tank(350, 305, Directions.RIGHT, Graphics.PLAYER2, "player2");

    }

    void start() {

        init();

        music.play(true);
        music.setLoop(1);

        try {

            while (!gameOver()) {
                Thread.sleep(DELAY);

                refreshBullets();
                refreshTanks();
                collisionDetector.collisionCheck(player1,player2);
            }

            if (player2.isDestroyed()){
                Picture gameOver = new Picture(344, 286, "stackP2.png");
                gameOver.draw();
            }

            if (player1.isDestroyed()){
                Picture gameOver = new Picture(344, 286, "stackP1.png");
                gameOver.draw();
            }
            music.close();

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    private boolean gameOver (){
        return (player1.isDestroyed() || player2.isDestroyed());
    }

    private void refreshBullets(){
        player1.bulletRefresh(DISTANCE);
        player2.bulletRefresh(DISTANCE);
    }

    private void refreshTanks(){
        player1.movePosition(DISTANCE);
        collisionDetector.tankCollisionCheck(player1,player2);
        player2.movePosition(DISTANCE);
        collisionDetector.collisionCheck(player2,player1);
    }

    private FreeMemory throwPickable (){
        return new FreeMemory();
    }

    public Tank getPlayer1() {
        return this.player1;
    }

    public Tank getPlayer2() {
        return this.player2;
    }

}
