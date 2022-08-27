package main.fedorchenko.currency_calculator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CurrencyXMLParser {
    private static final String FIlE_NAME = "src/task/fedorchenko/currency_calculator/data/eurofxref-daily.xml";
    public CurrencyXMLParser(){

    }

    public double parseCurrency(String targetCurrency){
        try {
            File inputFile = new File(FIlE_NAME);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Cube");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                Element element = (Element) nNode;
                if(!element.hasChildNodes()){
                    if(element.getAttributeNode("currency").getValue().equals(targetCurrency)){
                        return Double.parseDouble(element.getAttributeNode("rate").getValue());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Currency : " + targetCurrency + " does not exists!");
    }
}
