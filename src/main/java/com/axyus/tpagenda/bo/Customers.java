package com.axyus.tpagenda.bo;

public class Customers {
    
    private int customerId;
    private String lastName;
    private String firstName;
    private String username;
    private String email;

    public Customers() {
    }

    public Customers(int customerId, String lastName, String firstName, String username, String email) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
}
