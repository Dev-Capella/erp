package com.capella.facade.qualitylevel.impl;

import com.capella.domain.data.qualitylevel.QualityLevelData;
import com.capella.domain.model.qualitylevel.QualityLevelModel;
import com.capella.facade.qualitylevel.QualityLevelFacade;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.service.model.ModelService;
import com.capella.service.qualitylevel.QualityLevelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class QualityLevelFacadeImpl implements QualityLevelFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ItemTypeService itemTypeService;
    protected final QualityLevelService qualityLevelService;
    @Override
    public void save(QualityLevelData qualityLevelData) {
        QualityLevelModel qualityLevelModel;
        if(qualityLevelData.isNew()){
            qualityLevelModel = modelMapper.map(qualityLevelData, QualityLevelModel.class);
            qualityLevelModel.setCode(UUID.randomUUID().toString());
        }else{
            qualityLevelModel = qualityLevelService.getQualityLevelModel(qualityLevelData.getCode());
            modelMapper.map(qualityLevelData, qualityLevelModel);
        }
        qualityLevelModel.setItemType(itemTypeService.getItemTypeModel(qualityLevelData.getItemTypeData().getCode()));
        modelService.save(qualityLevelModel);
    }

    @Override
    public void delete(String code) {
        var qualityLevelModel = qualityLevelService.getQualityLevelModel(code);
        modelService.remove(qualityLevelModel);
    }
}
