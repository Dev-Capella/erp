package com.capella.facade.usergenericgroupdetail.impl;

import com.capella.domain.data.compositiondetail.CompositionDetailData;
import com.capella.domain.data.usergenericgroupdetail.UserGenericGroupDetailData;
import com.capella.domain.model.compositiondetail.CompositionDetailModel;
import com.capella.domain.model.usergenericgroupdetail.UserGenericGroupDetailModel;
import com.capella.facade.compositiondetail.CompositionDetailFacade;
import com.capella.facade.usergenericgroupdetail.UserGenericGroupDetailFacade;
import com.capella.service.composition.CompositionService;
import com.capella.service.compositioncomponent.CompositionComponentService;
import com.capella.service.compositiondetail.CompositionDetailService;
import com.capella.service.model.ModelService;
import com.capella.service.usergenericgroup.UserGenericGroupService;
import com.capella.service.usergenericgroupdetail.UserGenericGroupDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class UserGenericGroupDetailFacadeImpl implements UserGenericGroupDetailFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final UserGenericGroupDetailService userGenericGroupDetailService;
    protected final UserGenericGroupService userGenericGroupService;
    @Override
    public void save(UserGenericGroupDetailData userGenericGroupDetailData) {
        UserGenericGroupDetailModel userGenericGroupDetailModel;
        if(userGenericGroupDetailData.isNew()){
            userGenericGroupDetailModel = modelMapper.map(userGenericGroupDetailData, UserGenericGroupDetailModel.class);
            userGenericGroupDetailModel.setCode(UUID.randomUUID().toString());
        }else{
            userGenericGroupDetailModel = userGenericGroupDetailService.getUserGenericGroupDetailModel(userGenericGroupDetailData.getCode());
            modelMapper.map(userGenericGroupDetailModel, userGenericGroupDetailModel);
        }
        userGenericGroupDetailModel.setUserGenericGroup(userGenericGroupService.getUserGenericGroupModel(userGenericGroupDetailData.getUserGenericGroup().getCode()));
        modelService.save(userGenericGroupDetailModel);
    }

    @Override
    public void delete(String code) {
        var userGenericGroupDetailModel = userGenericGroupDetailService.getUserGenericGroupDetailModel(code);
        modelService.remove(userGenericGroupDetailModel);
    }

    @Override
    public UserGenericGroupDetailData get(String code) {
        var userGenericGroupDetailModel = userGenericGroupDetailService.getUserGenericGroupDetailModel(code);
        return modelMapper.map(userGenericGroupDetailModel, UserGenericGroupDetailData.class);
    }
}
