package com.capella.service.orderpartner.impl;

import com.capella.domain.model.orderpartner.OrderPartnerModel;
import com.capella.persistence.dao.orderpartner.OrderPartnerDao;
import com.capella.service.orderpartner.OrderPartnerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class OrderPartnerServiceImpl implements OrderPartnerService {

    private final OrderPartnerDao orderPartnerDao;

    @Override
    public OrderPartnerModel getOrderPartnerModel(String code) {
        var orderPartnerModel = orderPartnerDao.getByCode(code);
        return orderPartnerModel;
    }

    @Override
    public Set<OrderPartnerModel> getOrderPartnerModels() {
        List<OrderPartnerModel> orderPartnerModels = orderPartnerDao.findAll();
        Set<OrderPartnerModel> orderPartnerModelSet = new HashSet<>(orderPartnerModels);
        return orderPartnerModelSet;
    }
}
