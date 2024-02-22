package com.capella.service.policy.impl;

import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ItemNature;
import com.capella.domain.model.itemsubcodechecktype.ItemSubCodeCheckTypeModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.service.policy.Policy;
import com.capella.service.policy.PolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Policy
@RequiredArgsConstructor
@Slf4j
public class ItemSubCodeCheckTypePolicy implements PolicyService<ItemSubCodeCheckTypeModel> {

    /*
    Item sub code checktype seçimi yapılan yerde sağlanması gereken alan;
     */

    protected final ItemTypeService itemTypeService;

    @Override
    public <R> R invokeAndGetResult(ItemSubCodeCheckTypeModel model) {
        List<ItemTypeModel> designItemTypes = itemTypeService.getItemTypeModels()
                .stream()
                .filter(item -> ItemNature.DESIGN.equals(item.getItemNature()))
                .collect(Collectors.toList());
        return (R) designItemTypes;
    }
}
