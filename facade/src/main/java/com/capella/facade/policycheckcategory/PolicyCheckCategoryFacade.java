package com.capella.facade.policycheckcategory;

import com.capella.domain.data.policycheckcategory.PolicyCheckCategoryData;

import java.util.Set;

public interface PolicyCheckCategoryFacade {
    void save(PolicyCheckCategoryData policyCheckCategoryData);
    Set<PolicyCheckCategoryData> getAll();
    PolicyCheckCategoryData get(String code);
    void delete(String code);
}
