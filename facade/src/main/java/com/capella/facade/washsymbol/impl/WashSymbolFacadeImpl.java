package com.capella.facade.washsymbol.impl;

import com.capella.domain.data.washsymbol.WashSymbolData;
import com.capella.domain.model.washsymbol.WashSymbolModel;
import com.capella.domain.model.washsymbolcategory.WashSymbolCategoryModel;
import com.capella.facade.washsymbol.WashSymbolFacade;
import com.capella.service.model.ModelService;
import com.capella.service.washsymbol.WashSymbolService;
import com.capella.service.washsymbolcategory.WashSymbolCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class WashSymbolFacadeImpl implements WashSymbolFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final WashSymbolService washSymbolService;
    protected final WashSymbolCategoryService washSymbolCategoryService;
    @Override
    public void save(WashSymbolData washSymbolData) {
        WashSymbolModel washSymbolModel;
        if(washSymbolData.isNew()){
            washSymbolModel = modelMapper.map(washSymbolData, WashSymbolModel.class);
            washSymbolModel.setCode(UUID.randomUUID().toString());
        }else{
            washSymbolModel = washSymbolService.getWashSymbolModel(washSymbolData.getCode());
            modelMapper.map(washSymbolData, washSymbolModel);
        }
        WashSymbolCategoryModel washSymbolCategoryModel = null;
        if(Objects.nonNull(washSymbolData.getWashSymbolCategory())){
            washSymbolCategoryModel = washSymbolCategoryService.getWashSymbolCategoryModel(washSymbolData.getWashSymbolCategory().getCode());
        }
        washSymbolModel.setWashSymbolCategory(washSymbolCategoryModel);
        modelService.save(washSymbolModel);
    }

    @Override
    public Set<WashSymbolData> getAll() {
        var washSymbolModels = washSymbolService.getWashSymbolModels();
        return Set.of(modelMapper.map(washSymbolModels, WashSymbolData[].class));
    }

    @Override
    public WashSymbolData get(String code) {
        var washSymbolModel = washSymbolService.getWashSymbolModel(code);
        return modelMapper.map(washSymbolModel, WashSymbolData.class);
    }

    @Override
    public void delete(String code) {
        var washSymbolModel = washSymbolService.getWashSymbolModel(code);
        modelService.remove(washSymbolModel);
    }
}
