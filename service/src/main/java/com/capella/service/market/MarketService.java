package com.capella.service.market;

import com.capella.domain.model.market.MarketModel;

import java.util.Set;

public interface MarketService {
    MarketModel getMarketModel(String code);
    Set<MarketModel> getMarketModels();
}
