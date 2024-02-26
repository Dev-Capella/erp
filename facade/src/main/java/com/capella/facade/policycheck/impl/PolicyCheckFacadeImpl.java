package com.capella.facade.policycheck.impl;

import com.capella.domain.data.policycheck.PolicyCheckData;
import com.capella.domain.model.policycheck.PolicyCheckModel;
import com.capella.domain.model.policycheckcategory.PolicyCheckCategoryModel;
import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;
import com.capella.facade.policycheck.PolicyCheckFacade;
import com.capella.service.model.ModelService;
import com.capella.service.policycheck.PolicyCheckService;
import com.capella.service.policycheckcategory.PolicyCheckCategoryService;
import com.capella.service.util.ServiceUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

@Component
@AllArgsConstructor
@Slf4j
public class PolicyCheckFacadeImpl implements PolicyCheckFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final PolicyCheckCategoryService policyCheckCategoryService;
    protected final PolicyCheckService policyCheckService;

    @Override
    public void save(PolicyCheckData policyCheckData) {
        PolicyCheckModel policyCheckModel;
        if(policyCheckData.isNew()){
            policyCheckModel = modelMapper.map(policyCheckData, PolicyCheckModel.class);
            ServiceUtils.generateCodeIfMissing(policyCheckModel);
        }else{
            policyCheckModel = policyCheckService.getPolicyCheckModel(policyCheckData.getCode());
            modelMapper.map(policyCheckData, policyCheckModel);
        }
        PolicyCheckCategoryModel policyCheckCategoryModel = null;
        if(Objects.nonNull(policyCheckData.getPolicyCheckCategory())){
            policyCheckCategoryModel = policyCheckCategoryService.getPolicyCheckCategoryModel(policyCheckData.getPolicyCheckCategory().getCode());
        }
        policyCheckModel.setPolicyCheckCategory(policyCheckCategoryModel);
        modelService.save(policyCheckModel);
    }

    @Override
    public Set<PolicyCheckData> getAll() {
        var policyCheckModels = policyCheckService.getPolicyCheckModels();
        return Set.of(modelMapper.map(policyCheckModels, PolicyCheckData[].class));
    }

    @Override
    public PolicyCheckData get(String code) {
        var policyCheckModel = policyCheckService.getPolicyCheckModel(code);
        return modelMapper.map(policyCheckModel,PolicyCheckData.class);
    }

    @Override
    public void delete(String code) {
        var policyCheckModel = policyCheckService.getPolicyCheckModel(code);
        modelService.remove(policyCheckModel);
    }
}
