package com.capella.facade.itemtype.impl;

import com.capella.domain.data.bomitemsubcode.BoMItemSubCodeData;
import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.data.productitemsubcode.ProductItemSubCodeData;
import com.capella.domain.data.qualitylevel.QualityLevelData;
import com.capella.domain.data.routingitemsubcode.RoutingItemSubCodeData;
import com.capella.domain.enums.ItemSubCodeType;
import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import com.capella.facade.itemtype.ItemTypeFacade;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.service.model.ModelService;
import com.capella.service.unitofmeasure.UnitOfMeasureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class ItemTypeFacadeImpl implements ItemTypeFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ItemTypeService itemTypeService;
    protected final UnitOfMeasureService unitOfMeasureService;
    @Override
    public ItemTypeData save(ItemTypeData itemTypeData) {
        ItemTypeModel itemTypeModel;
        if(itemTypeData.isNew()){
            itemTypeModel = modelMapper.map(itemTypeData, ItemTypeModel.class);
            itemTypeModel.setCode(UUID.randomUUID().toString());
        }else{
            itemTypeModel = itemTypeService.getItemTypeModel(itemTypeData.getCode());
            modelMapper.map(itemTypeData, itemTypeModel);
        }
        UnitOfMeasureModel primaryUOM = null;
        if(Objects.nonNull(itemTypeData.getPrimaryUOM())){
            primaryUOM = unitOfMeasureService.getUnitOfMeasureModel(itemTypeData.getPrimaryUOM().getCode());
        }
        itemTypeModel.setPrimaryUOM(primaryUOM);
        UnitOfMeasureModel secondaryUOM = null;
        if(Objects.nonNull(itemTypeData.getSecondaryUOM()) && itemTypeData.getSecondaryUnitControlled()){
            secondaryUOM = unitOfMeasureService.getUnitOfMeasureModel(itemTypeData.getSecondaryUOM().getCode());
        }
        itemTypeModel.setSecondaryUOM(secondaryUOM);
        UnitOfMeasureModel packagingUOM = null;
        if(Objects.nonNull(itemTypeData.getPackagingUOM()) && itemTypeData.getPackagingUnitControlled()){
            packagingUOM = unitOfMeasureService.getUnitOfMeasureModel(itemTypeData.getPackagingUOM().getCode());
        }
        itemTypeModel.setPackagingUOM(packagingUOM);
        modelService.save(itemTypeModel);
        return modelMapper.map(itemTypeModel, ItemTypeData.class);
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

    @Override
    public Set<RoutingItemSubCodeData> getRoutingItemSubCodesByItemType(String code) {
        var itemTypeModel = itemTypeService.getItemTypeModel(code);
        var routingItemSubCodes = itemTypeModel.getRoutingItemSubCodes();
        return Set.of(modelMapper.map(routingItemSubCodes, RoutingItemSubCodeData[].class));
    }

    @Override
    public Set<BoMItemSubCodeData> getBoMItemSubCodesByItemType(String code) {
        var itemTypeModel = itemTypeService.getItemTypeModel(code);
        var bomItemSubCodes = itemTypeModel.getBomItemSubCodes();
        return Set.of(modelMapper.map(bomItemSubCodes, BoMItemSubCodeData[].class));
    }

    @Override
    public Set<ProductItemSubCodeData> getItemSubCodesByItemTypeForProduct(String code) {
        var itemTypeModel = itemTypeService.getItemTypeModel(code);
        var primaryItemSubCodes = itemTypeModel.getItemSubCodes().stream()
                .filter(itemSubCodeModel -> itemSubCodeModel.getType().equals(ItemSubCodeType.PRIMARY))
                .collect(Collectors.toList());
        Set<ProductItemSubCodeData> productItemSubCodeDataList = new HashSet<>();
        for (ItemSubCodeModel itemSubCodeModel : primaryItemSubCodes) {
            ProductItemSubCodeData productItemSubCodeData = new ProductItemSubCodeData();
            productItemSubCodeData.setLabel(itemSubCodeModel.getShortText());
            productItemSubCodeDataList.add(productItemSubCodeData);
        }
        return productItemSubCodeDataList;

    }
}
