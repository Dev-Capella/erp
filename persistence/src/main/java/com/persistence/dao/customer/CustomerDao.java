package com.persistence.dao.customer;

import com.capella.domain.model.customer.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerModel,Long> {
    CustomerModel findByName(String name);
}
