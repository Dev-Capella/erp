package com.capella.service.unitofmeasure;

import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;

import java.util.Set;

public interface UnitOfMeasureService {
    UnitOfMeasureModel getUnitOfMeasureModel(String code);
    Set<UnitOfMeasureModel> getUnitOfMeasureModels();

}
