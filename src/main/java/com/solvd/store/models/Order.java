package com.solvd.store.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.store.parsers.jaxb.DateAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Order {
    @XmlAttribute
    @JsonProperty("order_id")
    private Integer order_id;
    @JsonProperty("customer_id")
    private Integer customer_id;
    @JsonFormat(pattern = "MM-dd-yyyy")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDate order_date;
    @JsonProperty("total_price")
    private Double total_price;
    @JsonProperty("shipping_address_id")
    private Integer shipping_address_id;
    @JsonProperty("employees_id")
    private Integer employee_id;
    @JsonProperty("order_status_id")
    private Integer order_Status_id;

    public Order(int customer_id, LocalDate order_date, Double total_price, int shipping_address_id, int employees_id, int order_Status_id) {
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.total_price = total_price;
        this.shipping_address_id = shipping_address_id;
        this.employee_id = employees_id;
        this.order_Status_id = order_Status_id;
    }

    public Order() {
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

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public int getShipping_address_id() {
        return shipping_address_id;
    }

    public void setShipping_address_id(int shipping_address_id) {
        this.shipping_address_id = shipping_address_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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
                ", employees_id=" + employee_id +
                ", order_Status_id=" + order_Status_id +
                '}';
    }
}
