package com.capella.facade.orderpartner;

import com.capella.domain.data.orderpartner.OrderPartnerData;

import java.util.Set;

public interface OrderPartnerFacade {
    void save(OrderPartnerData orderPartnerData);
    Set<OrderPartnerData> getAll();
    OrderPartnerData get(String code);
    void delete(String code);
}
