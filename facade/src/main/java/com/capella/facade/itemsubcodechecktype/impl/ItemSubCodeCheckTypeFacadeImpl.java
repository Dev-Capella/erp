package com.capella.facade.itemsubcodechecktype.impl;

import com.capella.domain.data.itemsubcodechecktype.ItemSubCodeCheckTypeData;
import com.capella.domain.data.itemsubcodechecktype.PLItemSubCodeCheckTypeData;
import com.capella.domain.model.itemsubcodechecktype.ItemSubCodeCheckTypeModel;
import com.capella.domain.model.policycheck.PolicyCheckModel;
import com.capella.facade.itemsubcodechecktype.ItemSubCodeCheckTypeFacade;
import com.capella.service.itemsubcodechecktype.ItemSubCodeCheckTypeService;
import com.capella.service.model.ModelService;
import com.capella.facade.policy.PolicyEvaluate;
import com.capella.service.policycheck.PolicyCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class ItemSubCodeCheckTypeFacadeImpl implements ItemSubCodeCheckTypeFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ItemSubCodeCheckTypeService itemSubCodeCheckTypeService;
    protected final PolicyCheckService policyCheckService;
    protected final ApplicationContext applicationContext;
    @Override
    public void save(ItemSubCodeCheckTypeData itemSubCodeCheckTypeData) {
        ItemSubCodeCheckTypeModel itemSubCodeCheckTypeModel;
        if(itemSubCodeCheckTypeData.isNew()){
            itemSubCodeCheckTypeModel = modelMapper.map(itemSubCodeCheckTypeData, ItemSubCodeCheckTypeModel.class);
            itemSubCodeCheckTypeModel.setCode(UUID.randomUUID().toString());
        }else{
            itemSubCodeCheckTypeModel = itemSubCodeCheckTypeService.getItemSubCodeCheckTypeModel(itemSubCodeCheckTypeData.getCode());
            modelMapper.map(itemSubCodeCheckTypeData, itemSubCodeCheckTypeModel);
        }
        PolicyCheckModel policyCheckModel = null;
        if(Objects.nonNull(itemSubCodeCheckTypeData.getPolicyCheck())){
            policyCheckModel = policyCheckService.getPolicyCheckModel(itemSubCodeCheckTypeData.getPolicyCheck().getCode());
        }
        itemSubCodeCheckTypeModel.setPolicyCheck(policyCheckModel);
        modelService.save(itemSubCodeCheckTypeModel);
    }

    @Override
    public Set<ItemSubCodeCheckTypeData> getAll() {
        var itemSubCodeCheckTypeModels = itemSubCodeCheckTypeService.getItemSubCodeCheckTypeModels();
        return Set.of(modelMapper.map(itemSubCodeCheckTypeModels, ItemSubCodeCheckTypeData[].class));
    }

    @Override
    public ItemSubCodeCheckTypeData get(String code) {
        var itemSubCodeCheckTypeModel = itemSubCodeCheckTypeService.getItemSubCodeCheckTypeModel(code);
        return modelMapper.map(itemSubCodeCheckTypeModel,ItemSubCodeCheckTypeData.class);
    }

    @Override
    public void delete(String code) {
        var itemSubCodeCheckTypeModel = itemSubCodeCheckTypeService.getItemSubCodeCheckTypeModel(code);
        modelService.remove(itemSubCodeCheckTypeModel);
    }

    @Override
    public PLItemSubCodeCheckTypeData getItemSubCodeCheckTypeByPolicyFacade(String code) {
        var itemSubCodeCheckTypeModel = itemSubCodeCheckTypeService.getItemSubCodeCheckTypeModel(code);

        if(Objects.nonNull(itemSubCodeCheckTypeModel.getPolicyCheck())){
            var policy = itemSubCodeCheckTypeModel.getPolicyCheck().getPolicy();
            var policyEvaluate = (PolicyEvaluate) applicationContext.getBean(policy);
            return (PLItemSubCodeCheckTypeData) policyEvaluate.invoke();
        }else{
            return null;
        }

    }

}
