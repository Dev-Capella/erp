package com.capella.service.itemsubcodechecktype;

import com.capella.domain.model.itemsubcodechecktype.ItemSubCodeCheckTypeModel;

import java.util.Set;

public interface ItemSubCodeCheckTypeService {
    ItemSubCodeCheckTypeModel getItemSubCodeCheckTypeModel(String code);
    Set<ItemSubCodeCheckTypeModel> getItemSubCodeCheckTypeModels();
}
