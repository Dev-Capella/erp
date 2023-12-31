package com.capella.persistence.dao.costcategory;

import com.capella.domain.model.costcategory.CostCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostCategoryDao extends JpaRepository<CostCategoryModel, Long> {
    CostCategoryModel getByCode(String code);
    List<CostCategoryModel> findAll();
}
