package com.capella.facade.permission.impl;

import com.capella.domain.data.permission.PermissionData;
import com.capella.domain.model.permission.PermissionModel;
import com.capella.facade.permission.PermissionFacade;
import com.capella.service.model.ModelService;
import com.capella.service.permission.PermissionService;
import com.capella.service.util.ServiceUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class PermissionFacadeImpl implements PermissionFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final PermissionService permissionService;

    @Override
    public void save(PermissionData permissionData) {
        PermissionModel permissionModel;
        if(permissionData.isNew()){
            permissionModel = modelMapper.map(permissionData, PermissionModel.class);
            ServiceUtils.generateCodeIfMissing(permissionModel);
        }else{
            permissionModel = permissionService.getPermissionModel(permissionData.getCode());
            modelMapper.map(permissionData, permissionModel);
        }

        modelService.save(permissionModel);
    }

    @Override
    public Set<PermissionData> getAll() {
        var permissionModels = permissionService.getPermissionModels();
        return Set.of(modelMapper.map(permissionModels, PermissionData[].class));
    }

    @Override
    public PermissionData get(String code) {
        var permissionModel = permissionService.getPermissionModel(code);
        return modelMapper.map(permissionModel,PermissionData.class);
    }

    @Override
    public void delete(String code) {
        var permissionModel = permissionService.getPermissionModel(code);
        modelService.remove(permissionModel);
    }
}
