package com.capella.facade.itemsubcode.impl;

import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import com.capella.facade.itemsubcode.ItemSubCodeFacade;
import com.capella.service.itemsubcode.ItemSubCodeService;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class ItemSubCodeFacadeImpl implements ItemSubCodeFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ItemTypeService itemTypeService;
    protected final ItemSubCodeService itemSubCodeService;

    @Override
    public void save(ItemSubCodeData itemSubCodeData) {
        ItemSubCodeModel itemSubCodeModel;
        if(itemSubCodeData.isNew()){
            itemSubCodeModel = modelMapper.map(itemSubCodeData, ItemSubCodeModel.class);
            itemSubCodeModel.setCode(UUID.randomUUID().toString());
        }else{
            itemSubCodeModel = itemSubCodeService.getItemSubCodeModel(itemSubCodeData.getCode());
            modelMapper.map(itemSubCodeData, itemSubCodeModel);
        }
        itemSubCodeModel.setItemType(itemTypeService.getItemTypeModel(itemSubCodeData.getItemTypeData().getCode()));
        modelService.save(itemSubCodeModel);
    }

    @Override
    public void delete(String code) {
        var itemSubCodeModel = itemSubCodeService.getItemSubCodeModel(code);
        modelService.remove(itemSubCodeModel);
    }
}
