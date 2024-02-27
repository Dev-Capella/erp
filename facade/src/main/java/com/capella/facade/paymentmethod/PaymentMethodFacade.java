package com.capella.facade.paymentmethod;

import com.capella.domain.data.paymentmethod.PaymentMethodData;

import java.util.Set;

public interface PaymentMethodFacade {
    void save(PaymentMethodData paymentMethodData);
    Set<PaymentMethodData> getAll();
    PaymentMethodData get(String code);
    void delete(String code);
}
