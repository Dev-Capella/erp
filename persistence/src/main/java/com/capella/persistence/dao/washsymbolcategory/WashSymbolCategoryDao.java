package com.capella.persistence.dao.washsymbolcategory;

import com.capella.domain.model.washsymbolcategory.WashSymbolCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WashSymbolCategoryDao extends JpaRepository<WashSymbolCategoryModel, Long> {
    WashSymbolCategoryModel getByCode(String code);
    List<WashSymbolCategoryModel> findAll();
}
