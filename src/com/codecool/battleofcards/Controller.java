package com.codecool.battleofcards;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Controller {

    private CardDaoXml cardDaoXml = new CardDaoXml();
    private List<Card> deck;

    public Controller() {

        createDeck();
    }

    public List<Card> getDeck() {

        return deck;
    }

    public void createDeck() throws NullPointerException {

        deck = cardDaoXml.getAllCards();
    }

    public void runGame() throws InterruptedException {

        View view = new View();
        String selectionOfMenu = "";
        boolean wantToExit = false;

        while (!wantToExit) {
            do {
                view.displayMenu();
                view.displayMessage(view.validateSelectionOfMenu(selectionOfMenu));

                selectionOfMenu = view.getInput("Selection: ");
                switch (selectionOfMenu) {
                case "1":
                    startGame();
                    break;
                case "2":
                    Game game = new Game(deck);
                    game.printCards();
                    break;
                case "3":
                    view.print("Closed correctly.");
                    wantToExit = true;
                    break;
                }
            } while (view.validateSelectionOfMenu(selectionOfMenu));
        }
    }

    public void startGame() throws InterruptedException {

        View view = new View();
        String typeOfGame = "";

        do {
            view.displayTypeOfGame();
            view.displayMessage(view.validateTypeOfGameSelection(typeOfGame));
            Game game = new Game(deck);
            typeOfGame = view.getInput("Type of game: ");
            game.createPlayers(typeOfGame);
        } while (view.validateTypeOfGameSelection(typeOfGame));
    }

    public static void main(String[] args) throws InterruptedException {

        Controller controller = new Controller();
        controller.runGame();
    }
}
