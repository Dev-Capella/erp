package com.capella.facade.routingitemsubcode.impl;

import com.capella.domain.data.routingitemsubcode.RoutingItemSubCodeData;
import com.capella.domain.model.routingitemsubcode.RoutingItemSubCodeModel;
import com.capella.facade.routingitemsubcode.RoutingItemSubCodeFacade;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.service.model.ModelService;
import com.capella.service.routingitemsubcode.RoutingItemSubCodeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class RoutingItemSubCodeFacadeImpl implements RoutingItemSubCodeFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ItemTypeService itemTypeService;
    protected final RoutingItemSubCodeService routingItemSubCodeService;

    @Override
    public void save(RoutingItemSubCodeData routingItemSubCodeData) {
        RoutingItemSubCodeModel routingItemSubCodeModel;
        if(routingItemSubCodeData.isNew()){
            routingItemSubCodeModel = modelMapper.map(routingItemSubCodeData, RoutingItemSubCodeModel.class);
            routingItemSubCodeModel.setCode(UUID.randomUUID().toString());
        }else{
            routingItemSubCodeModel = routingItemSubCodeService.getRoutingItemSubCodeModel(routingItemSubCodeData.getCode());
            modelMapper.map(routingItemSubCodeData, routingItemSubCodeModel);
        }
        routingItemSubCodeModel.setItemType(itemTypeService.getItemTypeModel(routingItemSubCodeData.getItemType().getCode()));
        modelService.save(routingItemSubCodeModel);
    }

    @Override
    public void delete(String code) {
        var routingItemSubCodeModel = routingItemSubCodeService.getRoutingItemSubCodeModel(code);
        modelService.remove(routingItemSubCodeModel);
    }

    @Override
    public RoutingItemSubCodeData get(String code) {
        var routingItemSubCodeModel = routingItemSubCodeService.getRoutingItemSubCodeModel(code);
        return modelMapper.map(routingItemSubCodeModel, RoutingItemSubCodeData.class);
    }
}
