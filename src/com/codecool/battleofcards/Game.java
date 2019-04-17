
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

        case "1":
            player1 = new Human();
            player2 = new Human();
            break;

        case "2":
            player1 = new Human();
            player2 = new Ai();
            break;
        case "3":
            // Main.getController().runGame();
            break;
        }
    }

    private Boolean isYourCardStronger(Card card1, Card card2, int stat) {

        if (card1.getStat(stat) - card2.getStat(stat) > 0) {
            return true;
        } else if (card1.getStat(stat) - card2.getStat(stat) == 0) {
            return null;
        }
        return false;
    }

    private void moveCardsOnTable(Player activePlayer, Player secondPlayer) {

        table.add(activePlayer.getCard());
        table.add(secondPlayer.getCard());
        activePlayer.removeCard();
        secondPlayer.removeCard();
    }

    public void playGame() {

        Random random = new Random();
        boolean player1Turn = random.nextBoolean();
        String winner = "";
        

        while (gameOn) {
            if (player1Turn) {
                if (!playRound(player1, player2)); {
                    player1Turn = !player1Turn;
                }
            } else {
                if (!playRound(player2, player1)); {
                    player1Turn = !player1Turn;
                }
            }
            if (player1.getPile().getCards().size() == 0) {
                gameOn = false;
                winner = player2.getName();
            } else if (player2.getPile().getCards().size() == 0) {
                gameOn = false;
                winner = player1.getName();
            }
        }
        gameOver(winner);
    }

    private Boolean playRound(Player activePlayer, Player secondPlayer) {

        moveCardsOnTable(activePlayer, secondPlayer);
        int stat = activePlayer.chooseStatToPlay();
        Boolean didIWin = isYourCardStronger(table.get(table.size() -2), table.get(table.size() -1), stat);
        if (didIWin) {
            for (Card card : table) {
                activePlayer.getPile().getCards().add(0, card);
            }
            table.clear();
            return true;
        } else if (didIWin == null) {
            return null;
        } else {
            for (Card card : table) {
                secondPlayer.getPile().getCards().add(0, card);
            }
            table.clear(); 
        }
        return false;
    }

    private void gameOver(String winner) {
        System.out.println("Game over, the winner is " + winner + "!");
    }
}