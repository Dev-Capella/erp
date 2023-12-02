package com.capella.service.unitofmeasure.impl;

import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import com.capella.persistence.dao.unitofmeasure.UnitOfMeasureDao;
import com.capella.service.unitofmeasure.UnitOfMeasureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureDao unitOfMeasureDao;
    @Override
    public UnitOfMeasureModel getUnitOfMeasureModel(String code) {
        var unitOfMeasureModel = unitOfMeasureDao.getByCode(code);
        return unitOfMeasureModel;
    }
}
