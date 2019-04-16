
package com.codecool.battleofcards;

import java.util.Random;

class Game {

    private Pile deck = new Pile();
    private Pile table = new Pile();
    private boolean gameOn = true;
    private Player player1;
    private Player player2;

    public void createPlayers(String types) {

        switch (types) {

        case "H H":
        default:
            player1 = new Human();
            player2 = new Human();
            break;

        case "H A":
            player1 = new Human();
            player2 = new Ai();
            break;
        }
    }

    public void playRound() {

        Random random = new Random();
        boolean player1Turn = random.nextBoolean();

        while (gameOn) {
            if (player1turn) {
                player1.chooseStatToPlay();
            } else {
                player2.chooseStatToPlay();
            }

            player1Turn = !player1Turn;
        }
    }
}