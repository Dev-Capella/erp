package com.capella.facade.customer;

import com.capella.domain.model.customer.CustomerModel;

public interface CustomerFacade {
    CustomerModel getCustomerByName(String name);
}
