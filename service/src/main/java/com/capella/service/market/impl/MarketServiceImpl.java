package com.capella.service.market.impl;

import com.capella.domain.model.market.MarketModel;
import com.capella.persistence.dao.market.MarketDao;
import com.capella.service.market.MarketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class MarketServiceImpl implements MarketService {

    private final MarketDao marketDao;

    @Override
    public MarketModel getMarketModel(String code) {
        var marketModel = marketDao.getByCode(code);
        return marketModel;
    }

    @Override
    public Set<MarketModel> getMarketModels() {
        List<MarketModel> marketModels = marketDao.findAll();
        Set<MarketModel> marketModelSet = new HashSet<>(marketModels);
        return marketModelSet;
    }
}
