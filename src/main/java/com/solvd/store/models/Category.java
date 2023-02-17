package com.solvd.store.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Category")
public class Category {
    @XmlAttribute
    @JsonProperty("category_id")
    private Integer category_id ;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Category(){}

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
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
        return "Category{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
