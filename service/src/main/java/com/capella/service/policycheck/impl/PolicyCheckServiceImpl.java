package com.capella.service.policycheck.impl;

import com.capella.domain.model.policycheck.PolicyCheckModel;
import com.capella.persistence.dao.policycheck.PolicyCheckDao;
import com.capella.service.policycheck.PolicyCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class PolicyCheckServiceImpl implements PolicyCheckService {

    private final PolicyCheckDao policyCheckDao;
    @Override
    public PolicyCheckModel getPolicyCheckModel(String code) {
        var policyCheckModel = policyCheckDao.getByCode(code);
        return policyCheckModel;
    }

    @Override
    public Set<PolicyCheckModel> getPolicyCheckModels() {
        List<PolicyCheckModel> policyCheckModels = policyCheckDao.findAll();
        Set<PolicyCheckModel> policyCheckModelSet = new HashSet<>(policyCheckModels);
        return policyCheckModelSet;
    }
}
