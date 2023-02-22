package com.solvd.store.parsers.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.store.models.Customer;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File output = new File("." + File.separator + "src" + File.separator + File.separator + "main" +
                File.separator + File.separator + "resources" + File.separator + "jackson" + File.separator +
                "testCustomer.json");
        Customer customer = new Customer("John Smith","JSmith@gmail.com","123 fake st.");
        customer.setCustomer_id(20);
        Customer customer2 = new Customer();
        ObjectMapper om = new ObjectMapper();
        try {
            om.writeValue(output, customer);
            customer2 = om.readValue(output,Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(customer2);
    }
}
