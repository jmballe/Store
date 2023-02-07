package com.solvd.store.models;

public class Inventory {
    private Integer inventory_id;
    private int product_id;
    private int quantity;
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
