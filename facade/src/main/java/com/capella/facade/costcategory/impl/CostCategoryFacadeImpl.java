package com.capella.facade.costcategory.impl;

import com.capella.domain.data.costcategory.CostCategoryData;
import com.capella.domain.data.unitofmeasure.UnitOfMeasureData;
import com.capella.domain.model.costcategory.CostCategoryModel;
import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import com.capella.facade.costcategory.CostCategoryFacade;
import com.capella.service.costcategory.CostCategoryService;
import com.capella.service.model.ModelService;
import com.capella.service.unitofmeasure.UnitOfMeasureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class CostCategoryFacadeImpl implements CostCategoryFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CostCategoryService costCategoryService;

    @Override
    public void save(CostCategoryData costCategoryData) {
        CostCategoryModel costCategoryModel;
        if(costCategoryData.isNew()){
            costCategoryModel = modelMapper.map(costCategoryData, CostCategoryModel.class);
            costCategoryModel.setCode(UUID.randomUUID().toString());
        }else{
            costCategoryModel = costCategoryService.getCostCategoryModel(costCategoryData.getCode());
            modelMapper.map(costCategoryData, costCategoryModel);
        }
        modelService.save(costCategoryModel);
    }

    @Override
    public Set<CostCategoryData> getAll() {
        var costCategoryModels = costCategoryService.getCostCategoryModels();
        return Set.of(modelMapper.map(costCategoryModels, CostCategoryData[].class));
    }

    @Override
    public CostCategoryData get(String code) {
        var costCategoryModel = costCategoryService.getCostCategoryModel(code);
        return modelMapper.map(costCategoryModel,CostCategoryData.class);
    }

    @Override
    public void delete(String code) {
        var costCategoryModel = costCategoryService.getCostCategoryModel(code);
        modelService.remove(costCategoryModel);
    }
}
