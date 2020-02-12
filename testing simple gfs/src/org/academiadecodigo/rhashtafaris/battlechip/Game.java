package org.academiadecodigo.rhashtafaris.battlechip;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.CollisionDetector;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Grid;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Tank;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    private Grid canvas;
    private Tank player1;
    private Tank player2;
    private int delay;
    private static final int DISTANCE = 40;
    private CollisionDetector collisionDetector;

    public Game(int delay) {

        this.delay = delay;

    }

    public void init() {

        collisionDetector = new CollisionDetector(canvas);
        keyboardInit();
        canvas = new Grid(1280, 720);
        player1 = new Tank(20, 20, 300, collisionDetector);
        player2 = new Tank(20, 20, 500, collisionDetector);

    }

    public void start() throws InterruptedException {

        init();

        while (true) {

            player1.getPosition().convertPosition();
            player2.getPosition().convertPosition();

        }

    }

    private void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        /**
         * Player one keys
         */
        //Right - right
        KeyboardEvent rightPressP1 = new KeyboardEvent();
        rightPressP1.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightPressP1);

        //Left - left
        KeyboardEvent leftPressP1 = new KeyboardEvent();
        leftPressP1.setKey(KeyboardEvent.KEY_LEFT);
        leftPressP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftPressP1);

        //Up - up
        KeyboardEvent upPressP1 = new KeyboardEvent();
        upPressP1.setKey(KeyboardEvent.KEY_UP);
        upPressP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upPressP1);

        //Down - down
        KeyboardEvent downPressP1 = new KeyboardEvent();
        downPressP1.setKey(KeyboardEvent.KEY_DOWN);
        downPressP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downPressP1);

        //Shoot - m
        KeyboardEvent shootP1 = new KeyboardEvent();
        shootP1.setKey(KeyboardEvent.KEY_M);
        shootP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(shootP1);


        /**
         * Player two keys
         */
        //Right - d
        KeyboardEvent rightPressP2 = new KeyboardEvent();
        rightPressP2.setKey(KeyboardEvent.KEY_D);
        rightPressP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightPressP2);

        //Left - a
        KeyboardEvent leftPressP2 = new KeyboardEvent();
        leftPressP2.setKey(KeyboardEvent.KEY_A);
        leftPressP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftPressP2);

        //Up - w
        KeyboardEvent upPressP2 = new KeyboardEvent();
        upPressP2.setKey(KeyboardEvent.KEY_W);
        upPressP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upPressP2);

        //Down - s
        KeyboardEvent downPressP2 = new KeyboardEvent();
        downPressP2.setKey(KeyboardEvent.KEY_S);
        downPressP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downPressP2);

        //Shoot - c
        KeyboardEvent shootP2 = new KeyboardEvent();
        shootP2.setKey(KeyboardEvent.KEY_C);
        shootP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(shootP2);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                player1.move(Directions.UP, DISTANCE);

                break;

            case KeyboardEvent.KEY_W:
                player2.move(Directions.UP, DISTANCE);
                break;

            case KeyboardEvent.KEY_DOWN:
                player1.move(Directions.DOWN, DISTANCE);
                break;

            case KeyboardEvent.KEY_S:
                player2.move(Directions.DOWN, DISTANCE);
                break;

            case KeyboardEvent.KEY_LEFT:
                player1.move(Directions.LEFT, DISTANCE);
                break;

            case KeyboardEvent.KEY_A:
                player2.move(Directions.LEFT, DISTANCE);
                break;

            case KeyboardEvent.KEY_RIGHT:
                player1.move(Directions.RIGHT, DISTANCE);
                break;

            case KeyboardEvent.KEY_D:
                player2.move(Directions.RIGHT, DISTANCE);
                break;

            case KeyboardEvent.KEY_M:
                player1.shoot();
                break;

            case KeyboardEvent.KEY_C:
                player2.shoot();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
