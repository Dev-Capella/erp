package com.capella.facade.usergenericgroup.impl;

import com.capella.domain.data.compositiondetail.CompositionDetailData;
import com.capella.domain.data.unitofmeasure.UnitOfMeasureData;
import com.capella.domain.data.usergenericgroup.UserGenericGroupData;
import com.capella.domain.data.usergenericgroupdetail.UserGenericGroupDetailData;
import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;
import com.capella.facade.usergenericgroup.UserGenericGroupFacade;
import com.capella.service.model.ModelService;
import com.capella.service.unitofmeasure.UnitOfMeasureService;
import com.capella.service.usergenericgroup.UserGenericGroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class UserGenericGroupFacadeImpl implements UserGenericGroupFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final UserGenericGroupService userGenericGroupService;
    @Override
    public void save(UserGenericGroupData userGenericGroupData) {
        UserGenericGroupModel userGenericGroupModel;
        if(userGenericGroupData.isNew()){
            userGenericGroupModel = modelMapper.map(userGenericGroupData, UserGenericGroupModel.class);
            userGenericGroupModel.setCode(UUID.randomUUID().toString());
        }else{
            userGenericGroupModel = userGenericGroupService.getUserGenericGroupModel(userGenericGroupData.getCode());
            modelMapper.map(userGenericGroupData, userGenericGroupModel);
        }
        modelService.save(userGenericGroupModel);
    }

    @Override
    public Set<UserGenericGroupData> getAll() {
        var userGenericGroupModels = userGenericGroupService.getUserGenericGroupModels();
        return Set.of(modelMapper.map(userGenericGroupModels, UserGenericGroupData[].class));
    }

    @Override
    public UserGenericGroupData get(String code) {
        var userGenericGroupModel = userGenericGroupService.getUserGenericGroupModel(code);
        return modelMapper.map(userGenericGroupModel,UserGenericGroupData.class);
    }

    @Override
    public void delete(String code) {
        var userGenericGroupModel = userGenericGroupService.getUserGenericGroupModel(code);
        modelService.remove(userGenericGroupModel);
    }

    @Override
    public Set<UserGenericGroupDetailData> getUserGenericGroupDetailsByUserGenericGroup(String code) {
        var userGenericGroupModel = userGenericGroupService.getUserGenericGroupModel(code);
        var userGenericGroupDetails = userGenericGroupModel.getUserGenericGroupDetails();
        return Set.of(modelMapper.map(userGenericGroupDetails, UserGenericGroupDetailData[].class));
    }
}
