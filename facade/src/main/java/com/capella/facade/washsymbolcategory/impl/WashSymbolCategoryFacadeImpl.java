package com.capella.facade.washsymbolcategory.impl;

import com.capella.domain.data.washsymbolcategory.WashSymbolCategoryData;
import com.capella.domain.model.washsymbolcategory.WashSymbolCategoryModel;
import com.capella.facade.washsymbolcategory.WashSymbolCategoryFacade;
import com.capella.service.model.ModelService;
import com.capella.service.washsymbolcategory.WashSymbolCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class WashSymbolCategoryFacadeImpl implements WashSymbolCategoryFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final WashSymbolCategoryService washSymbolCategoryService;
    @Override
    public void save(WashSymbolCategoryData washSymbolCategoryData) {
        WashSymbolCategoryModel washSymbolCategoryModel;
        if(washSymbolCategoryData.isNew()){
            washSymbolCategoryModel = modelMapper.map(washSymbolCategoryData, WashSymbolCategoryModel.class);
            washSymbolCategoryModel.setCode(UUID.randomUUID().toString());
        }else{
            washSymbolCategoryModel = washSymbolCategoryService.getWashSymbolCategoryModel(washSymbolCategoryData.getCode());
            modelMapper.map(washSymbolCategoryData, washSymbolCategoryModel);
        }
        modelService.save(washSymbolCategoryModel);
    }

    @Override
    public Set<WashSymbolCategoryData> getAll() {
        var washSymbolCategoryModels = washSymbolCategoryService.getWashSymbolCategoryModels();
        return Set.of(modelMapper.map(washSymbolCategoryModels, WashSymbolCategoryData[].class));
    }

    @Override
    public WashSymbolCategoryData get(String code) {
        var washSymbolCategoryModel = washSymbolCategoryService.getWashSymbolCategoryModel(code);
        return modelMapper.map(washSymbolCategoryModel,WashSymbolCategoryData.class);
    }

    @Override
    public void delete(String code) {
        var washSymbolCategoryModel = washSymbolCategoryService.getWashSymbolCategoryModel(code);
        modelService.remove(washSymbolCategoryModel);
    }
}
