package com.codecool.battleofcards;

import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;

public class CardDaoXml implements CardDAO<Card> {
    private xmlReader reader = new xmlReader();
    private Document doc;

    public Document CardDaoXml() {
        doc = reader.loadXMLdocument("src/battleOfCards/xmls/cards.xml");
        return doc;
    }

    public List<Card> getAllCards() {
        List<Card> deck = new ArrayList<>();
        NodeList nlist = doc.getElementsByTagName("Airplane");

        for (int i = 0; i < nlist.getLength(); i++) {
            System.out.println(nlist.item(i));
        }

        return deck;

    }

}