package com.capella.facade.unitofmeasure;

import com.capella.domain.data.unitofmeasure.UnitOfMeasureData;

import java.util.Set;

public interface UnitOfMeasureFacade {
    void save(UnitOfMeasureData unitOfMeasureData);
    Set<UnitOfMeasureData> getAll();
    UnitOfMeasureData get(String code);
    void delete(String code);
}
