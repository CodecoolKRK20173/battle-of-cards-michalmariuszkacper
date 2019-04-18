package com.codecool.battleofcards;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Game {

    private List<Card> deck;
    private List<Card> table = new ArrayList<>();
    private Boolean gameOn;
    private Player player1;
    private Player player2;
    private View view = new View();
    private boolean flip;

    public Game(List<Card> deck) {

        this.deck = deck;
        gameOn = true;
    }

    private void dealCards(List<Card> deck) {

        for (int index = 0; index < deck.size(); index += 2) {
            player1.addCard(deck.get(index));
            player2.addCard(deck.get(index + 1));
        }
    }

    public void createPlayers(String types) throws InterruptedException {

        switch (types) {
        case "1":
            player1 = new Human(view.getInput("Enter Your name: "));
            player2 = new Human(view.getInput("Enter Your name: "));
            dealCards(deck);
            playGame();
            break;

        case "2":
            player1 = new Human(view.getInput("Enter Your name: "));
            player2 = new Ai("Computer");
            dealCards(deck);
            playGame();
            break;
        case "3":
            player1 = new Ai("Computer");
            player2 = new Ai("Computer 2");
            dealCards(deck);
            playGame();
        case "4":
            break;
        }
    }

    private int isYourCardStronger(Card card1, Card card2, int stat) {

        if (card1.getStat(stat) - card2.getStat(stat) > 0) {
            return 1;
        } else if (card1.getStat(stat) - card2.getStat(stat) == 0) {
            return 2;
        }
        return 3;
    }

    private void moveCardsOnTable(Player activePlayer, Player secondPlayer) {

        table.add(activePlayer.getCard());
        table.add(secondPlayer.getCard());
        activePlayer.removeCard();
        secondPlayer.removeCard();
    }

    public void playGame() throws InterruptedException {

        Random random = new Random();
        Boolean player1Turn = random.nextBoolean();
        String winner = "";

        while (gameOn) {

            if (player1Turn) {
                playRound(player1, player2);
            } else {
                playRound(player2, player1);
            }
            if (flip) {
                player1Turn = !player1Turn;
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

    private List<String> parseCardForPrint(Card card) {

        List<String> list = new ArrayList<>();

        list.add("Specification");
        list.add(card.getName());
        list.add("Max Speed");
        list.add(card.getFirstStat().toString());
        list.add("Ammo");
        list.add(card.getSecondStat().toString());
        list.add("Radar Range");
        list.add(card.getThirdStat().toString());
        list.add("Wing Span");
        list.add(card.getFourthStat().toString());
        return list;
    }

    private void playRound(Player activePlayer, Player secondPlayer) throws InterruptedException, NullPointerException {

        moveCardsOnTable(activePlayer, secondPlayer);
        view.clearScreen();
        view.print(activePlayer.getName() + "\'s move\n");
        CardsPrinter cardprinter = new CardsPrinter(parseCardForPrint(activePlayer.getCard()));
        cardprinter.prepareToPrint();
        view.print(cardprinter.getOutput());
        int stat = activePlayer.chooseStatToPlay();
        int didIWin = isYourCardStronger(table.get(table.size() - 2), table.get(table.size() - 1), stat);
        

        if (didIWin == 1) {
            for (Card card : table) {
                activePlayer.getPile().getCards().add(0, card);
            }
            flip = false;
            table.clear();
            view.print("\n" + activePlayer.getName() + " won this round!");
            TimeUnit.SECONDS.sleep(1);
        } else if (didIWin == 2) {
            view.print("\nIt's a draw!");
            TimeUnit.SECONDS.sleep(1);
            flip = false;
        } else {
            for (Card card : table) {
                secondPlayer.getPile().getCards().add(0, card);
            }
            flip = true;
            table.clear();
            view.print("\n" + secondPlayer.getName() + " won this round!");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void printCards() {

        for (Card card : deck) {
            CardsPrinter cp = new CardsPrinter(parseCardForPrint(card));
            cp.prepareToPrint();
            view.print(cp.getOutput());
        }
    }

    private void gameOver(String winner) throws InterruptedException {
        view.print("Game over, the winner is " + winner + "!");
        TimeUnit.SECONDS.sleep(5);
        Controller controller = new Controller();
        controller.runGame();
    }
}