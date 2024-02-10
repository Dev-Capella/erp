package com.capella.facade.itemsubcodechecktype.impl;

import com.capella.domain.data.itemsubcodechecktype.ItemSubCodeCheckTypeData;
import com.capella.domain.model.itemsubcodechecktype.ItemSubCodeCheckTypeModel;
import com.capella.facade.itemsubcodechecktype.ItemSubCodeCheckTypeFacade;
import com.capella.service.itemsubcodechecktype.ItemSubCodeCheckTypeService;
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
public class ItemSubCodeCheckTypeFacadeImpl implements ItemSubCodeCheckTypeFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ItemSubCodeCheckTypeService itemSubCodeCheckTypeService;

    @Override
    public void save(ItemSubCodeCheckTypeData itemSubCodeCheckTypeData) {
        ItemSubCodeCheckTypeModel itemSubCodeCheckTypeModel;
        if(itemSubCodeCheckTypeData.isNew()){
            itemSubCodeCheckTypeModel = modelMapper.map(itemSubCodeCheckTypeData, ItemSubCodeCheckTypeModel.class);
            itemSubCodeCheckTypeModel.setCode(UUID.randomUUID().toString());
        }else{
            itemSubCodeCheckTypeModel = itemSubCodeCheckTypeService.getItemSubCodeCheckTypeModel(itemSubCodeCheckTypeData.getCode());
            modelMapper.map(itemSubCodeCheckTypeData, itemSubCodeCheckTypeModel);
        }
        modelService.save(itemSubCodeCheckTypeModel);
    }

    @Override
    public Set<ItemSubCodeCheckTypeData> getAll() {
        var itemSubCodeCheckTypeModels = itemSubCodeCheckTypeService.getItemSubCodeCheckTypeModels();
        return Set.of(modelMapper.map(itemSubCodeCheckTypeModels, ItemSubCodeCheckTypeData[].class));
    }

    @Override
    public ItemSubCodeCheckTypeData get(String code) {
        var itemSubCodeCheckTypeModel = itemSubCodeCheckTypeService.getItemSubCodeCheckTypeModel(code);
        return modelMapper.map(itemSubCodeCheckTypeModel,ItemSubCodeCheckTypeData.class);
    }

    @Override
    public void delete(String code) {
        var itemSubCodeCheckTypeModel = itemSubCodeCheckTypeService.getItemSubCodeCheckTypeModel(code);
        modelService.remove(itemSubCodeCheckTypeModel);
    }
}
