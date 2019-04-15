package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.List;

class Pile {
    
    List<Card> cards = new ArrayList<>();


    public Card getTopCard() {

        return pile.get(pile.size() -1);
    }

    public List<Card> getCards() {

        return pile;
    }

    public void addCard(Card card) {
        cards.add(card);
        card.setContainingPile(this);
    }
}