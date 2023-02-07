package com.solvd.store.models;

public class Order_status {
    private Integer status_id;
    private String name;

    public Order_status(String name) {
        this.name = name;
    }

    public Order_status() {
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order_status{" +
                "status_id=" + status_id +
                ", name='" + name + '\'' +
                '}';
    }
}
