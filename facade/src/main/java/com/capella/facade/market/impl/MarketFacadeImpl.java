package com.capella.facade.market.impl;

import com.capella.domain.data.market.MarketData;
import com.capella.domain.model.market.MarketModel;
import com.capella.facade.market.MarketFacade;
import com.capella.service.market.MarketService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class MarketFacadeImpl implements MarketFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final MarketService marketService;

    @Override
    public void save(MarketData marketData) {
        MarketModel marketModel;
        if(marketData.isNew()){
            marketModel = modelMapper.map(marketData, MarketModel.class);
            marketModel.setCode(UUID.randomUUID().toString());
        }else{
            marketModel = marketService.getMarketModel(marketData.getCode());
            modelMapper.map(marketData, marketModel);
        }
        modelService.save(marketModel);
    }

    @Override
    public Set<MarketData> getAll() {
        var marketModels = marketService.getMarketModels();
        return Set.of(modelMapper.map(marketModels, MarketData[].class));
    }

    @Override
    public MarketData get(String code) {
        var marketModel = marketService.getMarketModel(code);
        return modelMapper.map(marketModel,MarketData.class);
    }

    @Override
    public void delete(String code) {
        var marketModel = marketService.getMarketModel(code);
        modelService.remove(marketModel);
    }
}
