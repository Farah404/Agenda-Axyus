package com.axyus.tpagenda.dal;

import com.axyus.tpagenda.bo.Address;
import com.axyus.tpagenda.bo.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Integer> {
}
