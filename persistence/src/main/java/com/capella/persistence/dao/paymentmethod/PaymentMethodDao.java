package com.capella.persistence.dao.paymentmethod;

import com.capella.domain.model.paymentmethod.PaymentMethodModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentMethodDao extends JpaRepository<PaymentMethodModel, Long> {
    PaymentMethodModel getByCode(String code);

    List<PaymentMethodModel> findAll();
}
