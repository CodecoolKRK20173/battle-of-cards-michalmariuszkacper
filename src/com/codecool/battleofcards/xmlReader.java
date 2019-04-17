package com.codecool.battleofcards;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public class xmlReader {
    private Document doc;

    public Document loadXMLdocument(String xmlPath) {
        try {

            File file = new File(xmlPath);
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dBF.newDocumentBuilder();
            doc = dBuilder.parse(file);
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    public Document getDocument() {
        return doc;
    }

}
