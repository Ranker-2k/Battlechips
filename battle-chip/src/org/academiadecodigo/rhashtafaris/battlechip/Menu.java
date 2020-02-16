package org.academiadecodigo.rhashtafaris.battlechip;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    private static Picture canvasMenu;
    private boolean gameStart;
    private boolean instructions;
    private boolean offInfo;


    public Menu() {
        gameStart = false;
        instructions = false;
        offInfo = false;
    }

    public void createMenu() {
        canvasMenu = new Picture(0, 0, "menu.png");
        canvasMenu.draw();


        try {

        while (!gameStart){

            Thread.sleep(200);

            if (instructions){
                startInstructions();
            }
        }
        }catch (InterruptedException ex){
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

    public void instructionsTrue(){
        instructions = true;
    }
}
