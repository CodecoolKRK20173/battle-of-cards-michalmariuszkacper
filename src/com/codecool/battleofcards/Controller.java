package com.codecool.battleofcards;

import java.util.Iterator;
import java.util.List;

public class Controller {

    private CardDaoXml cardDaoXml = new CardDaoXml();
    private List<Card> deck;
    private Player player1;
    private Player player2;

    private int playersNumber = 2;

    public List<Card> createDeck() {
        deck = cardDaoXml.getAllCards();
        return deck;
    }

    public List<Card> getDeck() {
        return deck;
    }

    // private Game game = new Game();

    public void runGame() {
        View view = new View();
        String selectionOfMenu = "";
        do {
            view.displayMenu();
            view.displayMessage(view.validateSelectionOfMenu(selectionOfMenu));

            selectionOfMenu = view.getInput("Selection: ");
            switch (selectionOfMenu) {
            case "1":
                // startGame();
                break;
            case "2":
                System.out.println("You picked option 2");
                break;
            case "3":
                System.out.println("Closed correctly.");
                break;
            }
        } while (view.validateSelectionOfMenu(selectionOfMenu));

    }

    // public void startGame() {
    // View view = new View();
    // String typeOfGame = "";
    // do {
    // view.displayTypeOfGame();
    // view.displayMessage(view.validateTypeOfGameSelection(typeOfGame));

    // typeOfGame = view.getInput("Type of game: ");
    // game.createPlayers(typeOfGame);
    // } while (view.validateTypeOfGameSelection(typeOfGame));

    // }
}
