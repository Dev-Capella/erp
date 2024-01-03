package com.capella.facade.manufacturer.impl;

import com.capella.domain.data.manufacturer.ManufacturerData;
import com.capella.domain.model.manufacturer.ManufacturerModel;
import com.capella.domain.model.media.MediaModel;
import com.capella.facade.manufacturer.ManufacturerFacade;
import com.capella.service.manufacturer.ManufacturerService;
import com.capella.service.media.MediaService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class ManufacturerFacadeImpl implements ManufacturerFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ManufacturerService manufacturerService;
    protected final MediaService mediaService;
    @Override
    public void save(ManufacturerData manufacturerData) {
        ManufacturerModel manufacturerModel;
        if(manufacturerData.isNew()){
            manufacturerModel = modelMapper.map(manufacturerData, ManufacturerModel.class);
            manufacturerModel.setCode(UUID.randomUUID().toString());
        }else{
            manufacturerModel = manufacturerService.getManufacturerModel(manufacturerData.getCode());
            modelMapper.map(manufacturerData, manufacturerModel);
        }
        MediaModel mediaModel = new MediaModel();
        if(Objects.nonNull(manufacturerData.getMedia())){
            mediaModel = mediaService.getMediaByCode(manufacturerData.getMedia().getCode());
        }
        manufacturerModel.setMedia(mediaModel);
        modelService.save(manufacturerModel);
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
