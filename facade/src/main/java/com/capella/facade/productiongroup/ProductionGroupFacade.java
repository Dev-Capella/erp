package com.capella.facade.productiongroup;

import com.capella.domain.data.productiongroup.ProductionGroupData;

import java.util.Set;

public interface ProductionGroupFacade {
    void save(ProductionGroupData productionGroupData);
    Set<ProductionGroupData> getAll();
    ProductionGroupData get(String code);
    void delete(String code);
}
