package com.capella.service.permission.impl;

import com.capella.domain.model.permission.PermissionModel;
import com.capella.persistence.dao.permission.PermissionDao;
import com.capella.service.permission.PermissionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PermissionServiceImpl implements PermissionService {
    private final PermissionDao permissionDao;

    @Override
    public PermissionModel getPermissionModel(String code) {
        var permissionModel = permissionDao.getByCode(code);
        return permissionModel;
    }
}
