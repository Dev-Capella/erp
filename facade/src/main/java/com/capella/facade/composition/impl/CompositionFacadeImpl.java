package com.capella.facade.composition.impl;

import com.capella.domain.data.bomitemsubcode.BoMItemSubCodeData;
import com.capella.domain.data.composition.CompositionData;
import com.capella.domain.data.compositiondetail.CompositionDetailData;
import com.capella.domain.model.composition.CompositionModel;
import com.capella.facade.composition.CompositionFacade;
import com.capella.service.composition.CompositionService;
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
public class CompositionFacadeImpl implements CompositionFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CompositionService compositionService;

    @Override
    public void save(CompositionData compositionData) {
        CompositionModel compositionModel;
        if(compositionData.isNew()){
            compositionModel = modelMapper.map(compositionData, CompositionModel.class);
            compositionModel.setCode(UUID.randomUUID().toString());
        }else{
            compositionModel = compositionService.getCompositionModel(compositionData.getCode());
            modelMapper.map(compositionData, compositionModel);
        }
        modelService.save(compositionModel);
    }

    @Override
    public Set<CompositionData> getAll() {
        var compositionModels = compositionService.getCompositionModels();
        return Set.of(modelMapper.map(compositionModels, CompositionData[].class));
    }

    @Override
    public CompositionData get(String code) {
        var compositionModel = compositionService.getCompositionModel(code);
        return modelMapper.map(compositionModel,CompositionData.class);
    }

    @Override
    public void delete(String code) {
        var compositionModel = compositionService.getCompositionModel(code);
        modelService.remove(compositionModel);
    }

    @Override
    public Set<CompositionDetailData> getCompositionDetailsByComposition(String code) {
        var compositionModel = compositionService.getCompositionModel(code);
        var compositionDetails = compositionModel.getCompositionDetails();
        return Set.of(modelMapper.map(compositionDetails, CompositionDetailData[].class));
    }
}
