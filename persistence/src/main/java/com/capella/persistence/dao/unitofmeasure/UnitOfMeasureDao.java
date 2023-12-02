package com.capella.persistence.dao.unitofmeasure;

import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitOfMeasureDao extends JpaRepository<UnitOfMeasureModel, Long> {
    UnitOfMeasureModel getByCode(String code);
}
