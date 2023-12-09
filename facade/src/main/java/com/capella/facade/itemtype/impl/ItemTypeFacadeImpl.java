package com.capella.facade.itemtype.impl;

import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.data.qualitylevel.QualityLevelData;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.facade.itemtype.ItemTypeFacade;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.service.model.ModelService;
import com.capella.service.unitofmeasure.UnitOfMeasureService;
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
public class ItemTypeFacadeImpl implements ItemTypeFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ItemTypeService itemTypeService;
    protected final UnitOfMeasureService unitOfMeasureService;
    @Override
    public void save(ItemTypeData itemTypeData) {
        ItemTypeModel itemTypeModel;
        if(itemTypeData.isNew()){
            itemTypeModel = modelMapper.map(itemTypeData, ItemTypeModel.class);
            itemTypeModel.setCode(UUID.randomUUID().toString());
        }else{
            itemTypeModel = itemTypeService.getItemTypeModel(itemTypeData.getCode());
            modelMapper.map(itemTypeData, itemTypeModel);
        }
        if(Objects.nonNull(itemTypeData.getPrimaryUOM())){
            var unitOfMeasureModel = unitOfMeasureService.getUnitOfMeasureModel(itemTypeData.getPrimaryUOM().getCode());
            itemTypeModel.setPrimaryUOM(unitOfMeasureModel);
        }
        if(Objects.nonNull(itemTypeData.getSecondaryUOM()) && itemTypeData.getSecondaryUnitControlled()){
            var unitOfMeasureModel = unitOfMeasureService.getUnitOfMeasureModel(itemTypeData.getSecondaryUOM().getCode());
            itemTypeModel.setSecondaryUOM(unitOfMeasureModel);
        }
        if(Objects.nonNull(itemTypeData.getPackagingUOM()) && itemTypeData.getPackagingUnitControlled()){
            var unitOfMeasureModel = unitOfMeasureService.getUnitOfMeasureModel(itemTypeData.getPackagingUOM().getCode());
            itemTypeModel.setPackagingUOM(unitOfMeasureModel);
        }
        modelService.save(itemTypeModel);
    }

    @Override
    public Set<ItemTypeData> getAll() {
        var itemTypeModels = itemTypeService.getItemTypeModels();
        return Set.of(modelMapper.map(itemTypeModels, ItemTypeData[].class));
    }

    @Override
    public ItemTypeData get(String code) {
        var itemTypeModel = itemTypeService.getItemTypeModel(code);
        return modelMapper.map(itemTypeModel,ItemTypeData.class);
    }

    @Override
    public void delete(String code) {
        var itemTypeModel = itemTypeService.getItemTypeModel(code);
        modelService.remove(itemTypeModel);
    }
    @Override
    public Set<ItemSubCodeData> getItemSubCodesByItemType(String code) {
        var itemTypeModel = itemTypeService.getItemTypeModel(code);
        var itemSubCodes = itemTypeModel.getItemSubCodes();
        return Set.of(modelMapper.map(itemSubCodes, ItemSubCodeData[].class));
    }

    @Override
    public Set<QualityLevelData> getQualityLevelsByItemType(String code) {
        var itemTypeModel = itemTypeService.getItemTypeModel(code);
        var qualityLevels = itemTypeModel.getQualityLevels();
        return Set.of(modelMapper.map(qualityLevels, QualityLevelData[].class));
    }
}
