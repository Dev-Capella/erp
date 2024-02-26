package com.capella.facade.policycheckcategory.impl;

import com.capella.domain.data.policycheckcategory.PolicyCheckCategoryData;
import com.capella.domain.model.policycheckcategory.PolicyCheckCategoryModel;
import com.capella.facade.policycheckcategory.PolicyCheckCategoryFacade;
import com.capella.service.model.ModelService;
import com.capella.service.policycheckcategory.PolicyCheckCategoryService;
import com.capella.service.util.ServiceUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
@Slf4j
public class PolicyCheckCategoryFacadeImpl implements PolicyCheckCategoryFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final PolicyCheckCategoryService policyCheckCategoryService;
    @Override
    public void save(PolicyCheckCategoryData policyCheckCategoryData) {
        PolicyCheckCategoryModel policyCheckCategoryModel;
        if(policyCheckCategoryData.isNew()){
            policyCheckCategoryModel = modelMapper.map(policyCheckCategoryData, PolicyCheckCategoryModel.class);
            ServiceUtils.generateCodeIfMissing(policyCheckCategoryModel);
        }else{
            policyCheckCategoryModel = policyCheckCategoryService.getPolicyCheckCategoryModel(policyCheckCategoryData.getCode());
            modelMapper.map(policyCheckCategoryData, policyCheckCategoryModel);
        }
        modelService.save(policyCheckCategoryModel);
    }

    @Override
    public Set<PolicyCheckCategoryData> getAll() {
        var policyCheckCategoryModels = policyCheckCategoryService.getPolicyCheckCategoryModels();
        return Set.of(modelMapper.map(policyCheckCategoryModels, PolicyCheckCategoryData[].class));
    }

    @Override
    public PolicyCheckCategoryData get(String code) {
        var policyCheckCategoryModel = policyCheckCategoryService.getPolicyCheckCategoryModel(code);
        return modelMapper.map(policyCheckCategoryModel, PolicyCheckCategoryData.class);
    }

    @Override
    public void delete(String code) {
        var policyCheckCategoryModel = policyCheckCategoryService.getPolicyCheckCategoryModel(code);
        modelService.remove(policyCheckCategoryModel);
    }
}
