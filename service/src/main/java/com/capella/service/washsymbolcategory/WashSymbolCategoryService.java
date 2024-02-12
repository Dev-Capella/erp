package com.capella.service.washsymbolcategory;

import com.capella.domain.model.washsymbolcategory.WashSymbolCategoryModel;

import java.util.Set;

public interface WashSymbolCategoryService {
    WashSymbolCategoryModel getWashSymbolCategoryModel(String code);
    Set<WashSymbolCategoryModel> getWashSymbolCategoryModels();
}
