package com.codecool.battleofcards;

public class Controller {

    private Deck deck;

    public Controller(CardDao cardDaoInput) {
        this.deck = cardDaoInput.getDeck();
    }

    public void printTest() {
        System.out.println(this.deck);
    }
}