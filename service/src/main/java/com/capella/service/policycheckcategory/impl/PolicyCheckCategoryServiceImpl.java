package com.capella.service.policycheckcategory.impl;

import com.capella.domain.model.policycheckcategory.PolicyCheckCategoryModel;
import com.capella.persistence.dao.policycheckcategory.PolicyCheckCategoryDao;
import com.capella.service.policycheckcategory.PolicyCheckCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class PolicyCheckCategoryServiceImpl implements PolicyCheckCategoryService {

    private final PolicyCheckCategoryDao policyCheckCategoryDao;
    @Override
    public PolicyCheckCategoryModel getPolicyCheckCategoryModel(String code) {
        var policyCheckCategoryModel = policyCheckCategoryDao.getByCode(code);
        return policyCheckCategoryModel;
    }

    @Override
    public Set<PolicyCheckCategoryModel> getPolicyCheckCategoryModels() {
        List<PolicyCheckCategoryModel> policyCheckCategoryModels = policyCheckCategoryDao.findAll();
        Set<PolicyCheckCategoryModel> policyCheckCategoryModelSet = new HashSet<>(policyCheckCategoryModels);
        return policyCheckCategoryModelSet;
    }
}
