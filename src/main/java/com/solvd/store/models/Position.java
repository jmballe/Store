package com.solvd.store.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Position {
    @XmlAttribute
    @JsonProperty("position_id")
    private Integer position_id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
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
