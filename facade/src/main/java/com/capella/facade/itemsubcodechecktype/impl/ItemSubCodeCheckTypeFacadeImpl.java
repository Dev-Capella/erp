package com.capella.facade.itemsubcodechecktype.impl;

import com.capella.domain.data.itemsubcodechecktype.ItemSubCodeCheckTypeData;
import com.capella.domain.data.itemsubcodechecktype.PLItemSubCodeCheckTypeData;
import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.model.itemsubcodechecktype.ItemSubCodeCheckTypeModel;
import com.capella.facade.itemsubcodechecktype.ItemSubCodeCheckTypeFacade;
import com.capella.service.itemsubcodechecktype.ItemSubCodeCheckTypeService;
import com.capella.service.model.ModelService;
import com.capella.service.policy.PolicyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
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
        PLItemSubCodeCheckTypeData plItemSubCodeCheckTypeData = new PLItemSubCodeCheckTypeData();
        if(Objects.nonNull(itemSubCodeCheckTypeModel.getPolicyCheck())){
            var policy = itemSubCodeCheckTypeModel.getPolicyCheck().getPolicy();
            var policyService = (PolicyService) applicationContext.getBean(policy);
            var result = policyService.invokeAndGetResult(itemSubCodeCheckTypeModel);
            plItemSubCodeCheckTypeData.setLabel("itemType");
            plItemSubCodeCheckTypeData.setData(Set.of(modelMapper.map(result, ItemTypeData[].class)));
            plItemSubCodeCheckTypeData.setItemSubCodeCheckTypeData(modelMapper.map(itemSubCodeCheckTypeModel,ItemSubCodeCheckTypeData.class));
        }else{
            plItemSubCodeCheckTypeData.setLabel("itemType");
            plItemSubCodeCheckTypeData.setData(List.of());
            plItemSubCodeCheckTypeData.setItemSubCodeCheckTypeData(modelMapper.map(itemSubCodeCheckTypeModel,ItemSubCodeCheckTypeData.class));
        }
        return plItemSubCodeCheckTypeData;
    }

}
