package com.capella.facade.market;

import com.capella.domain.data.market.MarketData;

import java.util.Set;

public interface MarketFacade {
    MarketData save(MarketData marketData);
    Set<MarketData> getAll();
    MarketData get(String code);
    void delete(String code);
}
