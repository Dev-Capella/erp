package com.capella.facade.compositiondetail.impl;

import com.capella.domain.data.compositiondetail.CompositionDetailData;
import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.model.compositioncomponent.CompositionComponentModel;
import com.capella.domain.model.compositiondetail.CompositionDetailModel;
import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import com.capella.facade.compositiondetail.CompositionDetailFacade;
import com.capella.service.composition.CompositionService;
import com.capella.service.compositioncomponent.CompositionComponentService;
import com.capella.service.compositiondetail.CompositionDetailService;
import com.capella.service.itemsubcode.ItemSubCodeService;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class CompositionDetailFacadeImpl implements CompositionDetailFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CompositionService compositionService;
    protected final CompositionDetailService compositionDetailService;
    protected final CompositionComponentService compositionComponentService;
    @Override
    public void save(CompositionDetailData compositionDetailData) {
        CompositionDetailModel compositionDetailModel;
        if(compositionDetailData.isNew()){
            compositionDetailModel = modelMapper.map(compositionDetailData, CompositionDetailModel.class);
            compositionDetailModel.setCode(UUID.randomUUID().toString());
        }else{
            compositionDetailModel = compositionDetailService.getCompositionDetailModel(compositionDetailData.getCode());
            modelMapper.map(compositionDetailData, compositionDetailModel);
        }
        CompositionComponentModel  compositionComponent = null;
        if(Objects.nonNull(compositionDetailData.getCompositionComponent())){
            compositionComponent = compositionComponentService.getCompositionComponentModel(compositionDetailData.getCompositionComponent().getCode());
        }
        compositionDetailModel.setCompositionComponent(compositionComponent);
        compositionDetailModel.setComposition(compositionService.getCompositionModel(compositionDetailData.getComposition().getCode()));
        modelService.save(compositionDetailModel);
    }

    @Override
    public void delete(String code) {
        var compositionDetailModel = compositionDetailService.getCompositionDetailModel(code);
        modelService.remove(compositionDetailModel);
    }

    @Override
    public CompositionDetailData get(String code) {
        var compositionDetailModel = compositionDetailService.getCompositionDetailModel(code);
        return modelMapper.map(compositionDetailModel, CompositionDetailData.class);
    }
}
