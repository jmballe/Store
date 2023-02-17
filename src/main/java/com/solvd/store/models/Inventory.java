package com.solvd.store.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Inventory {
    @XmlAttribute
    private Integer inventory_id;
    @JsonProperty("product_id")
    private int product_id;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("warehouse_id")
    private int warehouse_id;

    public Inventory(int product_id, int quantity, int warehouse_id) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.warehouse_id = warehouse_id;
    }

    public Inventory() {
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventory_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", warehouse_id=" + warehouse_id +
                '}';
    }
}
