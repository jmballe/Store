package com.solvd.store.parsers.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;

public class DOMParser {
    private Document doc;
    private Schema schema;
    private final String source;

    public DOMParser(String source) {
        this.source = source;
        try {
            doc = this.getDocumentFromResource();
            schema = this.getSchemaFromResources();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validateDOM() {
        try {
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(doc));
        } catch (SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private Document getDocumentFromResource() throws ParserConfigurationException, IOException, SAXException {
        InputStream docStream = this.getClass().getClassLoader()
                .getResourceAsStream("XML-XSD/" + source + ".xml");
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilderFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        return docBuilder.parse(docStream);
    }

    private Schema getSchemaFromResources() throws IOException, SAXException {
        InputStream schemaStream = getClass().getClassLoader()
                .getResourceAsStream("XML-XSD/" + source + ".xsd");
        Source schemaSource = new StreamSource(schemaStream);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return schemaFactory.newSchema(schemaSource);
    }

    public void printXML() {
        NodeList nodes = doc.getElementsByTagName(source.toLowerCase());

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                NodeList children = element.getChildNodes();
                System.out.println("Element " + i + ":");
                for (int j = 0; j < children.getLength(); j++) {
                    Node child = children.item(j);

                    if (child.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(child.getNodeName() + ": " + child.getTextContent());
                    }
                }
                System.out.println(" ");
            }
        }
    }
}
