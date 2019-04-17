
package com.codecool.battleofcards;

import java.util.Random;
import java.util.*;

class Game {

    private Controller controller = new Controller();

    private List<Card> basicDeck;
    private List<Card> table;

    private Boolean gameOn;
    private Player player1;
    private Player player2;

    public Game() {
        basicDeck = controller.createDeck();
        dealCards();
        gameOn = true;

    }

    public void runGame() {
        while (gameOn) {

        }
    }

    private void dealCards() {
        int playerDeckSize = basicDeck.size() / 2;
        Iterator<Card> deckIterator = basicDeck.iterator();
        for (int i = 1; i < basicDeck.size(); i++) {
            Card card = deckIterator.next();
            if (i <= playerDeckSize) {
                player1.addCard(card);
            } else {
                player2.addCard(card);
            }

        }

    }

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