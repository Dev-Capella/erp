package com.capella.facade.costcategory;

import com.capella.domain.data.costcategory.CostCategoryData;

import java.util.Set;

public interface CostCategoryFacade {
    void save(CostCategoryData costCategoryData);
    Set<CostCategoryData> getAll();
    CostCategoryData get(String code);
    void delete(String code);
}
