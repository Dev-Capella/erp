package com.capella.service.policycheck;

import com.capella.domain.model.policycheck.PolicyCheckModel;

import java.util.Set;

public interface PolicyCheckService {
    PolicyCheckModel getPolicyCheckModel(String code);
    Set<PolicyCheckModel> getPolicyCheckModels();
}
