package com.capella.facade.manufacturer.impl;

import com.capella.domain.data.manufacturer.ManufacturerData;
import com.capella.facade.manufacturer.ManufacturerFacade;
import com.capella.service.manufacturer.ManufacturerService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
@Slf4j
public class ManufacturerFacadeImpl implements ManufacturerFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ManufacturerService manufacturerService;
    @Override
    public void save(ManufacturerData manufacturerData) {

    }

    @Override
    public Set<ManufacturerData> getAll() {
        var manufacturerModels = manufacturerService.getManufacturerModels();
        return Set.of(modelMapper.map(manufacturerModels, ManufacturerData[].class));
    }

    @Override
    public ManufacturerData get(String code) {
        var manufacturerModel = manufacturerService.getManufacturerModel(code);
        return modelMapper.map(manufacturerModel,ManufacturerData.class);
    }

    @Override
    public void delete(String code) {
        var manufacturerModel = manufacturerService.getManufacturerModel(code);
        modelService.remove(manufacturerModel);
    }
}
