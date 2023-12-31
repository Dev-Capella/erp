package com.capella.service.routingitemsubcode.impl;

import com.capella.domain.model.routingitemsubcode.RoutingItemSubCodeModel;
import com.capella.persistence.dao.routingitemsubcode.RoutingItemSubCodeDao;
import com.capella.service.routingitemsubcode.RoutingItemSubCodeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RoutingItemSubCodeServiceImpl implements RoutingItemSubCodeService {

    private final RoutingItemSubCodeDao routingItemSubCodeDao;
    @Override
    public RoutingItemSubCodeModel getRoutingItemSubCodeModel(String code) {
        var routingItemSubCodeModel = routingItemSubCodeDao.getByCode(code);
        return routingItemSubCodeModel;
    }
}
