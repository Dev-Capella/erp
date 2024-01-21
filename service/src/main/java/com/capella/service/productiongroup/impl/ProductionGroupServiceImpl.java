package com.capella.service.productiongroup.impl;

import com.capella.domain.model.productiongroup.ProductionGroupModel;
import com.capella.persistence.dao.productiongroup.ProductionGroupDao;
import com.capella.service.productiongroup.ProductionGroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@AllArgsConstructor
@Slf4j
public class ProductionGroupServiceImpl implements ProductionGroupService {
    private final ProductionGroupDao productionGroupDao;
    @Override
    public ProductionGroupModel getProductionGroupModel(String code) {
        var productionGroupModel = productionGroupDao.getByCode(code);
        return productionGroupModel;
    }

    @Override
    public Set<ProductionGroupModel> getProductionGroupModels() {
        List<ProductionGroupModel> productionGroupModels = productionGroupDao.findAll();
        Set<ProductionGroupModel> productionGroupModelSet = new HashSet<>(productionGroupModels);
        return productionGroupModelSet;
    }
}
