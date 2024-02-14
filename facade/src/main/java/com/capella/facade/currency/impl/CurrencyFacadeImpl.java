package com.capella.facade.currency.impl;

import com.capella.domain.data.currency.CurrencyData;
import com.capella.domain.model.currency.CurrencyModel;
import com.capella.facade.currency.CurrencyFacade;
import com.capella.service.currency.CurrencyService;
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
public class CurrencyFacadeImpl implements CurrencyFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CurrencyService currencyService;
    @Override
    public void save(CurrencyData currencyData) {
        CurrencyModel currencyModel;
        if(currencyData.isNew()){
            currencyModel = modelMapper.map(currencyData, CurrencyModel.class);
            currencyModel.setCode(UUID.randomUUID().toString());
        }else{
            currencyModel = currencyService.getCurrencyModel(currencyData.getCode());
            modelMapper.map(currencyData, currencyModel);
        }
        modelService.save(currencyModel);
    }

    @Override
    public Set<CurrencyData> getAll() {
        var currencyModels = currencyService.getCurrencyModels();
        return Set.of(modelMapper.map(currencyModels, CurrencyData[].class));
    }

    @Override
    public CurrencyData get(String code) {
        var currencyModel = currencyService.getCurrencyModel(code);
        return modelMapper.map(currencyModel,CurrencyData.class);
    }

    @Override
    public void delete(String code) {
        var currencyModel = currencyService.getCurrencyModel(code);
        modelService.remove(currencyModel);
    }
}
