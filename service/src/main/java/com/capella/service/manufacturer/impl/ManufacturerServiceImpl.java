package com.capella.service.manufacturer.impl;

import com.capella.domain.model.manufacturer.ManufacturerModel;
import com.capella.persistence.dao.manufacturer.ManufacturerDao;
import com.capella.service.manufacturer.ManufacturerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerDao manufacturerDao;
    @Override
    public ManufacturerModel getManufacturerModel(String code) {
        var manufacturerModel = manufacturerDao.getByCode(code);
        return manufacturerModel;
    }

    @Override
    public Set<ManufacturerModel> getManufacturerModels() {
        List<ManufacturerModel> manufacturerModels = manufacturerDao.findAll();
        Set<ManufacturerModel> manufacturerModelSet = new HashSet<>(manufacturerModels);
        return manufacturerModelSet;
    }
}
