package com.capella.facade.userrole.impl;

import com.capella.domain.data.userrole.UserRoleData;
import com.capella.domain.model.permission.PermissionModel;
import com.capella.domain.model.userrole.UserRoleModel;
import com.capella.facade.userrole.UserRoleFacade;
import com.capella.service.model.ModelService;
import com.capella.service.permission.PermissionService;
import com.capella.service.userrole.UserRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class UserRoleFacadeImpl implements UserRoleFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final PermissionService permissionService;
    protected final UserRoleService userRoleService;

    @Override
    public void save(UserRoleData userRoleData) {
        UserRoleModel userRoleModel;
        if(userRoleData.isNew()){
            userRoleModel = modelMapper.map(userRoleData, UserRoleModel.class);
            userRoleModel.setCode(UUID.randomUUID().toString());
        }else{
            userRoleModel = userRoleService.getUserRoleModel(userRoleData.getCode());
            modelMapper.map(userRoleData, userRoleModel);
        }
        Set<PermissionModel> permissions = new HashSet<>();
        if(CollectionUtils.isNotEmpty(userRoleData.getPermissions())){
            userRoleData.getPermissions().forEach(p ->
                    permissions.add(permissionService.getPermissionModel(p.getCode())));
        }
        userRoleModel.setPermissions(permissions);
        modelService.save(userRoleModel);
    }

    @Override
    public Set<UserRoleData> getAll() {
        var userRoleModels = userRoleService.getUserRoleModels();
        return Set.of(modelMapper.map(userRoleModels, UserRoleData[].class));
    }

    @Override
    public UserRoleData get(String code) {
        var userRoleModel = userRoleService.getUserRoleModel(code);
        return modelMapper.map(userRoleModel,UserRoleData.class);
    }

    @Override
    public void delete(String code) {
        var userRoleModel = userRoleService.getUserRoleModel(code);
        modelService.remove(userRoleModel);
    }
}
