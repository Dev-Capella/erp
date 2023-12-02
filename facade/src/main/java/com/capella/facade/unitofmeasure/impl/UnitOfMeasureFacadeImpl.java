package com.capella.facade.unitofmeasure.impl;

import com.capella.domain.data.unitofmeasure.UnitOfMeasureData;
import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import com.capella.facade.unitofmeasure.UnitOfMeasureFacade;
import com.capella.service.model.ModelService;
import com.capella.service.unitofmeasure.UnitOfMeasureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class UnitOfMeasureFacadeImpl implements UnitOfMeasureFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final UnitOfMeasureService unitOfMeasureService;

    @Override
    public void save(UnitOfMeasureData unitOfMeasureData) {
        UnitOfMeasureModel unitOfMeasureModel;
        if(unitOfMeasureData.isNew()){
            unitOfMeasureModel = modelMapper.map(unitOfMeasureData, UnitOfMeasureModel.class);
            unitOfMeasureModel.setCode(UUID.randomUUID().toString());
        }else{
            unitOfMeasureModel = unitOfMeasureService.getUnitOfMeasureModel(unitOfMeasureData.getCode());
            modelMapper.map(unitOfMeasureData, unitOfMeasureModel);
        }
        modelService.save(unitOfMeasureModel);
    }
}
