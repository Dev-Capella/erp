package com.capella.facade.paymentmethod.impl;

import com.capella.domain.data.paymentmethod.PaymentMethodData;
import com.capella.domain.model.paymentmethod.PaymentMethodModel;
import com.capella.facade.paymentmethod.PaymentMethodFacade;
import com.capella.service.model.ModelService;
import com.capella.service.paymentmethod.PaymentMethodService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class PaymentMethodFacadeImpl implements PaymentMethodFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final PaymentMethodService paymentMethodService;

    @Override
    public void save(PaymentMethodData paymentMethodData) {
        PaymentMethodModel paymentMethodModel;
        if(paymentMethodData.isNew()){
            paymentMethodModel = modelMapper.map(paymentMethodData, PaymentMethodModel.class);
            paymentMethodModel.setCode(UUID.randomUUID().toString());
        }else{
            paymentMethodModel = paymentMethodService.getPaymentMethodModel(paymentMethodData.getCode());
            modelMapper.map(paymentMethodData, paymentMethodModel);
        }
        modelService.save(paymentMethodModel);
    }

    @Override
    public Set<PaymentMethodData> getAll() {
        var paymentMethodModels = paymentMethodService.getPaymentMethodModels();
        return Set.of(modelMapper.map(paymentMethodModels, PaymentMethodData[].class));
    }

    @Override
    public PaymentMethodData get(String code) {
        var paymentMethodModel = paymentMethodService.getPaymentMethodModel(code);
        return modelMapper.map(paymentMethodModel,PaymentMethodData.class);
    }

    @Override
    public void delete(String code) {
        var paymentMethodModel = paymentMethodService.getPaymentMethodModel(code);
        modelService.remove(paymentMethodModel);
    }
}
