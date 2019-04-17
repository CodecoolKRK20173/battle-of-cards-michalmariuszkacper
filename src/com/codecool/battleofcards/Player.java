package com.codecool.battleofcards;

import java.util.*;

public class Player {

    private Pile cards;
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;

    }

    public void addCard(Card card) {
        cards.addCardToPile(card);
    }

    private Pile getPile() {
        return cards;
    }

    public int chooseStatToPlay() {
        return 0;
    }
}