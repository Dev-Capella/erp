package com.capella.persistence.dao.policycheckcategory;

import com.capella.domain.model.policycheckcategory.PolicyCheckCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyCheckCategoryDao extends JpaRepository<PolicyCheckCategoryModel, Long> {

    PolicyCheckCategoryModel getByCode(String code);

    List<PolicyCheckCategoryModel> findAll();
}
