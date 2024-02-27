package com.capella.service.paymentmethod;

import com.capella.domain.model.paymentmethod.PaymentMethodModel;

import java.util.Set;

public interface PaymentMethodService {
    PaymentMethodModel getPaymentMethodModel(String code);
    Set<PaymentMethodModel> getPaymentMethodModels();
}
