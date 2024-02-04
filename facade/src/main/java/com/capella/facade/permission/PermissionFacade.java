package com.capella.facade.permission;

import com.capella.domain.data.permission.PermissionData;

import java.util.Set;

public interface PermissionFacade {
    void save(PermissionData permissionData);
    Set<PermissionData> getAll();
    PermissionData get(String code);
    void delete(String code);
}
