package com.capella.service.itemtype;

import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;

import java.util.Set;

public interface ItemTypeService {
    ItemTypeModel getItemTypeModel(String code);
    Set<ItemTypeModel> getItemTypeModels();
}
