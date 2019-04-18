package com.codecool.battleofcards;


public class Player {

    private Pile cards = new Pile();
    private String playerName;

    public Player(String playerName) {
        
        this.playerName = playerName;
    }

    public Player() {
    }

    public void addCard(Card card) {
        cards.addCardToPile(card);
    }

    public void removeCard() {
        cards.removeCard();
    }

    public Card getCard() {
        return cards.getTopCard();
    }

    public Pile getPile() {
        return cards;
    }

    public int chooseStatToPlay() throws InterruptedException {
        return 0;
    }

    public String getName() {
        return playerName;
    }

    public void setName(String name) {
        playerName = name;
    }
}