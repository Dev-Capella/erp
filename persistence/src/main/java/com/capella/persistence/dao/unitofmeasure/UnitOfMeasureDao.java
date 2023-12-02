package com.capella.persistence.dao.unitofmeasure;

import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UnitOfMeasureDao extends JpaRepository<UnitOfMeasureModel, Long> {
    UnitOfMeasureModel getByCode(String code);
    Set<UnitOfMeasureModel> getUnitOfMeasureModels();
}
