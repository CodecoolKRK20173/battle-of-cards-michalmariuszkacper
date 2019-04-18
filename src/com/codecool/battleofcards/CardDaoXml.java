package com.codecool.battleofcards;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import java.util.*;

public class CardDaoXml implements CardDAO<Card> {
    private XmlReader reader = new XmlReader();
    private Document doc;

    public Document cardDaoXml() {
        doc = reader.loadXMLdocument("src/com/codecool/battleofcards/resources/cards.xml");
        return doc;
    }

    public List<Card> getAllCards() {

        List<Card> deck = new ArrayList<>();
        NodeList nlist = cardDaoXml().getElementsByTagName("Airplane");
        System.out.println(nlist);

        for (int i = 0; i < nlist.getLength(); i++) {
            Node nNode = nlist.item(i);
            Element eElement = (Element) nNode;
            Attr atr = eElement.getAttributeNode("planeName");
            String name = atr.getValue();
            Node evals = eElement.getElementsByTagName("Evals").item(0);
            NodeList abilities = ((Element) evals).getElementsByTagName("Eval");
            ArrayList<Integer> listOfAbilityValues = new ArrayList<>();

            for (int j = 0; j < abilities.getLength(); j++) {
                String valueOfAbilityStr = ((Element) abilities.item(j)).getTextContent();
                int valueOfAbility = Integer.parseInt(valueOfAbilityStr);
                listOfAbilityValues.add(valueOfAbility);
            }
            Card card = new Card(name, listOfAbilityValues);
            deck.add(card);
        }
        return deck;
    }
}