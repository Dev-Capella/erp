package com.capella.service.washsymbolcategory.impl;

import com.capella.domain.model.washsymbolcategory.WashSymbolCategoryModel;
import com.capella.persistence.dao.washsymbolcategory.WashSymbolCategoryDao;
import com.capella.service.washsymbolcategory.WashSymbolCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class WashSymbolCategoryServiceImpl implements WashSymbolCategoryService {
    private final WashSymbolCategoryDao washSymbolCategoryDao;
    @Override
    public WashSymbolCategoryModel getWashSymbolCategoryModel(String code) {
        var washSymbolCategoryModel = washSymbolCategoryDao.getByCode(code);
        return washSymbolCategoryModel;
    }

    @Override
    public Set<WashSymbolCategoryModel> getWashSymbolCategoryModels() {
        List<WashSymbolCategoryModel> washSymbolCategoryModels = washSymbolCategoryDao.findAll();
        Set<WashSymbolCategoryModel> washSymbolCategoryModelSet = new HashSet<>(washSymbolCategoryModels);
        return washSymbolCategoryModelSet;
    }
}
