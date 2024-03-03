package com.capella.facade.area.impl;

import com.capella.domain.data.area.AreaData;
import com.capella.domain.model.area.AreaModel;
import com.capella.facade.area.AreaFacade;
import com.capella.service.area.AreaService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.awt.geom.Area;
import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class AreaFacadeImpl implements AreaFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final AreaService areaService;

    @Override
    public AreaData save(AreaData areaData) {
        AreaModel areaModel;
        if(areaData.isNew()){
            areaModel = modelMapper.map(areaData, AreaModel.class);
            areaModel.setCode(UUID.randomUUID().toString());
        }else{
            areaModel = areaService.getAreaModel(areaData.getCode());
            modelMapper.map(areaData, areaModel);
        }
        modelService.save(areaModel);
        return modelMapper.map(areaModel, AreaData.class);
    }

    @Override
    public Set<AreaData> getAll() {
        var areaModels = areaService.getAreaModels();
        return Set.of(modelMapper.map(areaModels, AreaData[].class));
    }

    @Override
    public AreaData get(String code) {
        var areaModel = areaService.getAreaModel(code);
        return modelMapper.map(areaModel,AreaData.class);
    }

    @Override
    public void delete(String code) {
        var areaModel = areaService.getAreaModel(code);
        modelService.remove(areaModel);
    }
}
