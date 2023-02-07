package com.solvd.store.models;

public class Position {
    private Integer position_id;
    private String name;
    private String description;

    public Position(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Position() {
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position_id=" + position_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
