package com.capella.service.costcategory;

import com.capella.domain.model.costcategory.CostCategoryModel;

import java.util.Set;

public interface CostCategoryService {
    CostCategoryModel getCostCategoryModel(String code);
    Set<CostCategoryModel> getCostCategoryModels();
}
