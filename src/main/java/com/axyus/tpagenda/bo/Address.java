package com.axyus.tpagenda.bo;

public class Address {

    private int addressId;
    private int streetNumber;
    private String streetName;
    private String city;
    private String postalCode;
    private String country;

    public Address(int addressId, int streetNumber, String streetName, String city, String postalCode, String country) {
        this.addressId = addressId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(int streetNumber, String streetName, String city, String postalCode, String country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" + "addressId=" + addressId + ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + ", postalCode=" + postalCode + ", country=" + country + '}';
    }

}
