package com.capella.facade.customer.impl;

import com.capella.domain.model.customer.CustomerModel;
import com.capella.facade.customer.CustomerFacade;
import com.capella.service.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerFacadeImpl implements CustomerFacade {

    protected final CustomerService customerService;
    @Override
    public CustomerModel getCustomerByName(String name) {
        var customer = customerService.getCustomerByName(name);
        return customer;
    }
}
