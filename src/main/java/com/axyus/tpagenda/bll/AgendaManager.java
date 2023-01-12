package com.axyus.tpagenda.bll;

import com.axyus.tpagenda.bo.Address;
import com.axyus.tpagenda.bo.Customer;
import java.util.List;

public interface AgendaManager {

    // Create
    public void createCustomer(Customer customer);

    public void createAddress(Address address);

    //Read
    List<Customer> getAllCustomers();

    List<Address> getAllAddresses();

    //Update
    public void updateCustomer(Customer customer);

    public void updateAddress(Address address);

    //Delete
    public void deleteCustomerById(Integer customerId);

    public void deleteAllCustomers();

}
