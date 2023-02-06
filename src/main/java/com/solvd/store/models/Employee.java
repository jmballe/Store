package com.solvd.store.models;

public class Employee {
    private int employee_id;
    private String name;
    private String email;
    private String address;
    private int position_id;

    public Employee(String name, String email, String address, int position_id) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.position_id = position_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employee_id=" + employee_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", position_id=" + position_id +
                '}';
    }
}
