package com.capella.service.customer;

import com.capella.domain.model.customer.CustomerModel;

public interface CustomerService {
    CustomerModel getCustomerByName(String name);
}
