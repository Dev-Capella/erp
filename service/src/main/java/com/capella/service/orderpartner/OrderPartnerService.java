package com.capella.service.orderpartner;

import com.capella.domain.model.orderpartner.OrderPartnerModel;

import java.util.Set;

public interface OrderPartnerService {
    OrderPartnerModel getOrderPartnerModel(String code);
    Set<OrderPartnerModel> getOrderPartnerModels();
}
