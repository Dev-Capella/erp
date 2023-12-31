package com.capella.service.costcategory.impl;

import com.capella.domain.model.costcategory.CostCategoryModel;
import com.capella.persistence.dao.costcategory.CostCategoryDao;
import com.capella.service.costcategory.CostCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class CostCategoryServiceImpl implements CostCategoryService {

    private final CostCategoryDao costCategoryDao;

    @Override
    public CostCategoryModel getCostCategoryModel(String code) {
        var costCategoryModel = costCategoryDao.getByCode(code);
        return costCategoryModel;
    }

    @Override
    public Set<CostCategoryModel> getCostCategoryModels() {
        List<CostCategoryModel> costCategoryModels = costCategoryDao.findAll();
        Set<CostCategoryModel> costCategoryModelSet = new HashSet<>(costCategoryModels);
        return costCategoryModelSet;
    }
}
