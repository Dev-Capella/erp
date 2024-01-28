package com.capella.service.permission;

import com.capella.domain.model.permission.PermissionModel;

public interface PermissionService {
    PermissionModel getPermissionModel(String code);
}
