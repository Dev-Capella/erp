package com.capella.service.customer.impl;

import com.capella.domain.model.customer.CustomerModel;
import com.capella.service.customer.CustomerService;
import com.persistence.dao.customer.CustomerDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    @Override
    public CustomerModel getCustomerByName(String name) {
        var customer = customerDao.findByName(name);
        return customer;
    }
}
