package com.solvd.store.parsers.jaxb;

import com.solvd.store.models.Customer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Smith","JSmith@gmail.com","123 fake st.");
        Customer customer2;
        customer.setCustomer_id(15);
        try {
            JAXBContext c = JAXBContext.newInstance(Customer.class);
            Marshaller m = c.createMarshaller();
            Unmarshaller um = c.createUnmarshaller();
            File output = new File("." + File.separator + "src" + File.separator + File.separator + "main" +
                    File.separator + File.separator + "resources" + File.separator + "JAXB" + File.separator +
                    "custTest.xml");
            m.marshal(customer, output);
            customer2 = (Customer) um.unmarshal(output);
            System.out.println(customer2);
        } catch(JAXBException e) {
            e.printStackTrace();
        }
    }
}
