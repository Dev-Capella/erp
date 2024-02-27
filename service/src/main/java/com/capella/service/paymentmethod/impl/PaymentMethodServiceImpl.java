package com.capella.service.paymentmethod.impl;

import com.capella.domain.model.paymentmethod.PaymentMethodModel;
import com.capella.persistence.dao.paymentmethod.PaymentMethodDao;
import com.capella.service.paymentmethod.PaymentMethodService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodDao paymentMethodDao;

    @Override
    public PaymentMethodModel getPaymentMethodModel(String code) {
        var paymentMethodModel = paymentMethodDao.getByCode(code);
        return paymentMethodModel;
    }

    @Override
    public Set<PaymentMethodModel> getPaymentMethodModels() {
        List<PaymentMethodModel> paymentMethodModels = paymentMethodDao.findAll();
        Set<PaymentMethodModel> paymentMethodModelSet = new HashSet<>(paymentMethodModels);
        return paymentMethodModelSet;
    }
}
