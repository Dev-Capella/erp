package com.capella.persistence.dao.orderpartner;

import com.capella.domain.model.orderpartner.OrderPartnerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderPartnerDao extends JpaRepository<OrderPartnerModel, Long> {
    OrderPartnerModel getByCode(String code);

    List<OrderPartnerModel> findAll();
}
