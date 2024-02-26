package com.capella.facade.policycheck;

import com.capella.domain.data.policycheck.PolicyCheckData;

import java.util.Set;

public interface PolicyCheckFacade {
    void save(PolicyCheckData policyCheckData);
    Set<PolicyCheckData> getAll();
    PolicyCheckData get(String code);
    void delete(String code);
}
