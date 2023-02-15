package com.solvd.store.parsers.xml;

public class Main {
    public static void main(String[] args) {

        String[] sources = {"Category","Customer","Employee","Order_status","Position"};

        for (var source: sources) {
            System.out.println(source + ": ");
            DOMParser parser = new DOMParser(source);
            parser.validateDOM();
            parser.printXML();
        }
    }
}
