package com.solvd.store.models;

public class Order {
    private int order_id;
    private int customer_id;
    private String order_date;
    private String total_price;
    private int shipping_address_id;
    private int employees_id;
    private int order_Status_id;

    public Order(int customer_id, String order_date, String total_price, int shipping_address_id, int employees_id, int order_Status_id) {
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.total_price = total_price;
        this.shipping_address_id = shipping_address_id;
        this.employees_id = employees_id;
        this.order_Status_id = order_Status_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public int getShipping_address_id() {
        return shipping_address_id;
    }

    public void setShipping_address_id(int shipping_address_id) {
        this.shipping_address_id = shipping_address_id;
    }

    public int getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }

    public int getOrder_Status_id() {
        return order_Status_id;
    }

    public void setOrder_Status_id(int order_Status_id) {
        this.order_Status_id = order_Status_id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", order_date='" + order_date + '\'' +
                ", total_price='" + total_price + '\'' +
                ", shipping_address_id=" + shipping_address_id +
                ", employees_id=" + employees_id +
                ", order_Status_id=" + order_Status_id +
                '}';
    }
}
