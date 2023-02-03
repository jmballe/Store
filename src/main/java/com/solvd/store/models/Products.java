package com.solvd.store.models;

public class Products {
    private int product_id;
    private String name;
    private String price;
    private String description;
    private int category_id;
    private int supplier_id;

    public Products(String name, String price, String description, int category_id, int supplier_id) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", category_id=" + category_id +
                ", supplier_id=" + supplier_id +
                '}';
    }
}
