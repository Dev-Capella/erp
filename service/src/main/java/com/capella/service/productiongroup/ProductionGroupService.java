package com.capella.service.productiongroup;

import com.capella.domain.model.productiongroup.ProductionGroupModel;

import java.util.Set;

public interface ProductionGroupService {
    ProductionGroupModel getProductionGroupModel(String code);
    Set<ProductionGroupModel> getProductionGroupModels();
}
