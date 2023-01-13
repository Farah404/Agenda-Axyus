package com.axyus.tpagenda.bll;

import com.axyus.tpagenda.bo.Address;
import com.axyus.tpagenda.bo.Customer;
import com.axyus.tpagenda.dal.AddressDao;
import com.axyus.tpagenda.dal.CustomerDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class AgendaManagerImpl implements AgendaManager {

    @Autowired
    protected CustomerDao customerDao;

    @Autowired
    protected AddressDao addressDao;

    @Override
    public void createCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void createAddress(Address address) {
        addressDao.save(address);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerDao.findAll();
    }

    @Override
    public List<Address> getAllAddresses() {
        return (List<Address>) addressDao.findAll();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void updateAddress(Address address) {
        addressDao.save(address);
    }

    @Override
    public void deleteCustomerById(Integer customerId) {
        customerDao.deleteById(customerId);
    }

    @Override
    public void deleteAllCustomers() {
        customerDao.deleteAll();
    }

}
