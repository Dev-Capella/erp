package com.capella.facade.itemsubcode.impl;

import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.data.qualitylevel.QualityLevelData;
import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import com.capella.domain.model.itemsubcodechecktype.ItemSubCodeCheckTypeModel;
import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;
import com.capella.facade.itemsubcode.ItemSubCodeFacade;
import com.capella.service.itemsubcode.ItemSubCodeService;
import com.capella.service.itemsubcodechecktype.ItemSubCodeCheckTypeService;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.service.model.ModelService;
import com.capella.service.usergenericgroup.UserGenericGroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class ItemSubCodeFacadeImpl implements ItemSubCodeFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ItemTypeService itemTypeService;
    protected final ItemSubCodeService itemSubCodeService;
    protected final ItemSubCodeCheckTypeService itemSubCodeCheckTypeService;
    protected final UserGenericGroupService userGenericGroupService;

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
        ItemSubCodeCheckTypeModel itemSubCodeCheckTypeModel = null;
        if(Objects.nonNull(itemSubCodeData.getItemSubCodeCheckType())){
            itemSubCodeCheckTypeModel = itemSubCodeCheckTypeService.getItemSubCodeCheckTypeModel(itemSubCodeData.getItemSubCodeCheckType().getCode());
        }
        itemSubCodeModel.setItemSubCodeCheckType(itemSubCodeCheckTypeModel);
        itemSubCodeModel.setItemType(itemTypeService.getItemTypeModel(itemSubCodeData.getItemType().getCode()));
        modelService.save(itemSubCodeModel);
    }

    @Override
    public void delete(String code) {
        var itemSubCodeModel = itemSubCodeService.getItemSubCodeModel(code);
        modelService.remove(itemSubCodeModel);
    }
    @Override
    public ItemSubCodeData get(String code) {
        var itemSubCodeModel = itemSubCodeService.getItemSubCodeModel(code);
        return modelMapper.map(itemSubCodeModel, ItemSubCodeData.class);
    }
}
