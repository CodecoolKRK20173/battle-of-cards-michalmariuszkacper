package com.codecool.battleofcards;

public class Main {
    private static Controller controller = new Controller();

    /**
     * @return the controller
     */
    public static Controller getController() {
        return controller;
    }
    public static void main(String[] args) {
        Main.getController().runGame();
    }
}