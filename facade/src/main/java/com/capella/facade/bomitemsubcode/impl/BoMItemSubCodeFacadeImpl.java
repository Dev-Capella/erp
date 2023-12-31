package com.capella.facade.bomitemsubcode.impl;

import com.capella.domain.data.bomitemsubcode.BoMItemSubCodeData;
import com.capella.domain.model.bomitemsubcode.BoMItemSubCodeModel;
import com.capella.facade.bomitemsubcode.BoMItemSubCodeFacade;
import com.capella.service.bomitemsubcode.BoMItemSubCodeService;
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
public class BoMItemSubCodeFacadeImpl implements BoMItemSubCodeFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ItemTypeService itemTypeService;
    protected final BoMItemSubCodeService bomItemSubCodeService;
    @Override
    public void save(BoMItemSubCodeData bomItemSubCodeData) {
        BoMItemSubCodeModel bomItemSubCodeModel;
        if(bomItemSubCodeData.isNew()){
            bomItemSubCodeModel = modelMapper.map(bomItemSubCodeData, BoMItemSubCodeModel.class);
            bomItemSubCodeModel.setCode(UUID.randomUUID().toString());
        }else{
            bomItemSubCodeModel = bomItemSubCodeService.getBoMItemSubCodeModel(bomItemSubCodeData.getCode());
            modelMapper.map(bomItemSubCodeData, bomItemSubCodeModel);
        }
        bomItemSubCodeModel.setItemType(itemTypeService.getItemTypeModel(bomItemSubCodeData.getItemType().getCode()));
        modelService.save(bomItemSubCodeModel);
    }

    @Override
    public void delete(String code) {
        var bomItemSubCodeModel = bomItemSubCodeService.getBoMItemSubCodeModel(code);
        modelService.remove(bomItemSubCodeModel);
    }

    @Override
    public BoMItemSubCodeData get(String code) {
        var bomItemSubCodeModel = bomItemSubCodeService.getBoMItemSubCodeModel(code);
        return modelMapper.map(bomItemSubCodeModel, BoMItemSubCodeData.class);
    }
}
