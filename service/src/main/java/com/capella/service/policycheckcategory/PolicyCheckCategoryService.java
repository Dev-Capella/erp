package com.capella.service.policycheckcategory;

import com.capella.domain.model.policycheckcategory.PolicyCheckCategoryModel;

import java.util.Set;

public interface PolicyCheckCategoryService {
    PolicyCheckCategoryModel getPolicyCheckCategoryModel(String code);
    Set<PolicyCheckCategoryModel> getPolicyCheckCategoryModels();
}
