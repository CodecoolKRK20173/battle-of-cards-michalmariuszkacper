package battleOfCards;

import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;



public class CardDaoXml {
    private xmlReader reader = new xmlReader();
    private Document doc;

    public Document CardDao() {

        doc = reader.loadXMLdocument("src/battleOfCards/xmls/cards.xml");
        return doc;
    }

    public List<Card> getAllCards() {
        Deck deck = new Deck();
        doc = CardDao();
        NodeList nlist = doc.getElementsByTagName("Airplane");

        for (int i = 0; i < nlist.getLength(); i++) {
            System.out.println(nlist.item(i));
        }

        return deck;

    }

}