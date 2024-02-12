package com.capella.facade.washsymbolcategory;

import com.capella.domain.data.washsymbolcategory.WashSymbolCategoryData;

import java.util.Set;

public interface WashSymbolCategoryFacade {
    void save(WashSymbolCategoryData washSymbolCategoryData);
    Set<WashSymbolCategoryData> getAll();
    WashSymbolCategoryData get(String code);
    void delete(String code);
}
