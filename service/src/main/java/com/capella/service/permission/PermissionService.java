package com.capella.service.permission;

import com.capella.domain.model.permission.PermissionModel;
import com.capella.domain.model.userrole.UserRoleModel;

import java.util.Set;

public interface PermissionService {
    PermissionModel getPermissionModel(String code);
    Set<PermissionModel> getPermissionModels();
}
