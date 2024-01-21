package com.capella.facade.productiongroup.impl;

import com.capella.domain.data.productiongroup.ProductionGroupData;
import com.capella.domain.model.productiongroup.ProductionGroupModel;
import com.capella.facade.productiongroup.ProductionGroupFacade;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.service.model.ModelService;
import com.capella.service.productiongroup.ProductionGroupService;
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
public class ProductionGroupFacadeImpl implements ProductionGroupFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ItemTypeService itemTypeService;
    protected final ProductionGroupService productionGroupService;
    @Override
    public void save(ProductionGroupData productionGroupData) {
        ProductionGroupModel productionGroupModel;
        if(productionGroupData.isNew()){
            productionGroupModel = modelMapper.map(productionGroupData, ProductionGroupModel.class);
            productionGroupModel.setCode(UUID.randomUUID().toString());
        }else{
            productionGroupModel = productionGroupService.getProductionGroupModel(productionGroupData.getCode());
            modelMapper.map(productionGroupData, productionGroupModel);
        }
        if(Objects.nonNull(productionGroupData.getItemType())){
            var itemType = itemTypeService.getItemTypeModel(productionGroupData.getItemType().getCode());
            productionGroupModel.setItemType(itemType);
        }
        modelService.save(productionGroupModel);
    }

    @Override
    public Set<ProductionGroupData> getAll() {
        var productionGroupModels = productionGroupService.getProductionGroupModels();
        return Set.of(modelMapper.map(productionGroupModels, ProductionGroupData[].class));
    }

    @Override
    public ProductionGroupData get(String code) {
        var productionGroupModel = productionGroupService.getProductionGroupModel(code);
        return modelMapper.map(productionGroupModel,ProductionGroupData.class);
    }

    @Override
    public void delete(String code) {
        var productionGroupModel = productionGroupService.getProductionGroupModel(code);
        modelService.remove(productionGroupModel);
    }
}
