package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.List;
// import battleOfCards.CardDaoXml;

public class Pile {

    private List<Card> hand = new ArrayList<>();

    public List<Card> getPile() {
        return hand;
    }

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

    // public void addCard(Card card) {
    // cards.add(card);
    // card.setContainingPile(this);
    // }
}