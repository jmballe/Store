package com.solvd.store.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Order_status {
    @XmlAttribute
    @JsonProperty("status_id")
    private Integer status_id;
    @JsonProperty("name")
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
