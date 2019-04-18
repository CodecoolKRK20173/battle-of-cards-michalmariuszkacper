package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.List;

public class Pile {

    private List<Card> hand = new ArrayList<>();

    public void addCardToPile(Card card) {

        hand.add(card);
    }

    public int getPileSize() {

        return hand.size() - 1;
    }

    public Card getTopCard() {

        return hand.get(hand.size() - 1);
    }

    public List<Card> getCards() {

        return hand;
    }

    public void removeCard() {

        hand.remove(hand.size() - 1);
    }
}