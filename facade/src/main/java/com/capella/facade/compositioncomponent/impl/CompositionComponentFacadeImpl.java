package com.capella.facade.compositioncomponent.impl;

import com.capella.domain.data.compositioncomponent.CompositionComponentData;
import com.capella.domain.model.compositioncomponent.CompositionComponentModel;
import com.capella.facade.compositioncomponent.CompositionComponentFacade;
import com.capella.service.compositioncomponent.CompositionComponentService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class CompositionComponentFacadeImpl implements CompositionComponentFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CompositionComponentService compositionComponentService;
    @Override
    public void save(CompositionComponentData compositionComponentData) {
        CompositionComponentModel compositionComponentModel;
        if(compositionComponentData.isNew()){
            compositionComponentModel = modelMapper.map(compositionComponentData, CompositionComponentModel.class);
            compositionComponentModel.setCode(UUID.randomUUID().toString());
        }else{
            compositionComponentModel = compositionComponentService.getCompositionComponentModel(compositionComponentData.getCode());
            modelMapper.map(compositionComponentData, compositionComponentModel);
        }
        modelService.save(compositionComponentModel);
    }

    @Override
    public Set<CompositionComponentData> getAll() {
        var compositionComponentModels = compositionComponentService.getCompositionComponentModels();
        return Set.of(modelMapper.map(compositionComponentModels, CompositionComponentData[].class));
    }

    @Override
    public CompositionComponentData get(String code) {
        var compositionComponentModel = compositionComponentService.getCompositionComponentModel(code);
        return modelMapper.map(compositionComponentModel,CompositionComponentData.class);
    }

    @Override
    public void delete(String code) {
        var compositionComponentModel = compositionComponentService.getCompositionComponentModel(code);
        modelService.remove(compositionComponentModel);
    }
}
