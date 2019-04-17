package com.codecool.battleofcards;

import java.util.Iterator;
import java.util.List;

// import battleOfCards.CardDaoXml;

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

    // public List<Card> removeDealtCardsFromDeck(List<Card> dealtCards, List<Card>
    // basicDeck) {
    // List<Card> deckWithoutDealtCards = new ArrayList<Card>();

    // for (Card cardDeck : basicDeck) {
    // for (Card cardDealtCard : dealtCards) {
    // if (cardDealtCard.getId() == cardDeck.getId()) {
    // deckWithoutDealtCards.add(cardDealthCard);
    // }
    // }
    // }
    // basicDeck.removeAll(deckWithoutDealtCards);
    // return basicDeck;

    // }

    // public List<Card> removeDealtCardsFromDeck(List<Card> dealtCards, List<Card>
    // basicDeck) {
    // List<Card> deckWithoutDealtCards = new ArrayList<Card>();
    // for (Card cardDeck : basicDeck) {
    // for (Card cardDealtCard : dealtCards) {
    // if (cardDealtCard.getId() == cardDeck.getId()) {
    // deckWithoutDealtCards.add(cardDealthCard);
    // }
    // }
    // }
    // basicDeck.removeAll(deckWithoutDealtCards);
    // return basicDeck;

    // }

}