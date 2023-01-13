package com.axyus.tpagenda.bo;

public class Customer {

    private int customerId;
    private String lastName;
    private String firstName;
    private String username;
    private String email;
    private Address address;

    public Customer() {
    }

    public Customer(int customerId, String lastName, String firstName, String username, String email) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
    }

    public Customer(int customerId, String lastName, String firstName, String username, String email, Address address) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", lastName=" + lastName + ", firstName=" + firstName + ", username=" + username + ", email=" + email + '}';
    }

}
