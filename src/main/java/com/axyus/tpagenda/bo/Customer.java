package com.axyus.tpagenda.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {

    private int customerId;
    private String lastName;
    private String firstName;
    private String username;
    private String email;
    private int phoneNumber;
    private int addressId;

    public Customer() {
    }

    public Customer(int customerId, String lastName, String firstName, String username, String email, int phoneNumber, int address) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
    }

    public Customer(String lastName, String firstName, String username, String email, int phoneNumber, int addressId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
    }
    
    public Customer(ResultSet rs) throws SQLException{
        this.customerId = rs.getInt("customer_id");
        this.lastName = rs.getString("lst_name");
        this.firstName = rs.getString("first_name");
        this.username = rs.getString("username");
        this.email = rs.getString("email");
        this.phoneNumber = rs.getInt("phone_number");
        this.addressId = rs.getInt("address_id");
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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", lastName=" + lastName + ", firstName=" + firstName + ", username=" + username + ", email=" + email + ", addressId=" + addressId + '}';
    }

}
