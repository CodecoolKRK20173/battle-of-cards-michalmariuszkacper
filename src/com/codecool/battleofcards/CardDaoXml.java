package com.codecool.battleofcards;

import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List;

public class CardDaoXml implements CardDAO<Card> {
    private XmlReader reader = new XmlReader();
    private Document doc;

    public Document cardDaoXml() {
        doc = reader.loadXMLdocument("cards.xml");
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