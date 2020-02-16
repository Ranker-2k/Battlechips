package org.academiadecodigo.rhashtafaris.battlechip;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    private static Picture canvasMenu;
    private boolean gameStart;
    private boolean instructions;
    private boolean offInfo;
    private Sound music;


    public Menu() {
        gameStart = false;
        instructions = false;
        offInfo = false;
        this.music = new Sound(" resources/sfx/gameTheme_4.wav");
    }

    public void createMenu() {
        canvasMenu = new Picture(0, 0, "menu.png");
        canvasMenu.draw();

        this.music.play(true);

        try {

            while (!gameStart) {

                Thread.sleep(200);

                if (instructions) {
                    startInstructions();
                }
            }
            this.music.close();

        } catch (InterruptedException ex) {
            System.out.println("menu rong!!!");
        }
    }

    void startGame() {
        if (!offInfo) {

            this.gameStart = true;
        }
    }

    void startInstructions() {

        if (!offInfo) {

            canvasMenu = new Picture(0, 0, "info.png");
            canvasMenu.draw();
            offInfo = true;
        }

    }

    public void backMenu() {

        if (offInfo) {

            instructions = false;
            offInfo = false;

            if (canvasMenu != null) {

                canvasMenu.delete();
                canvasMenu = null;
            }
        }
    }

    public void instructionsTrue() {
        instructions = true;
    }
}
