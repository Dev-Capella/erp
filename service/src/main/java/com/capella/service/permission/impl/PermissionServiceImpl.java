package com.capella.service.permission.impl;

import com.capella.domain.model.permission.PermissionModel;
import com.capella.persistence.dao.permission.PermissionDao;
import com.capella.service.permission.PermissionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Set<PermissionModel> getPermissionModels() {
        List<PermissionModel> permissionModels = permissionDao.findAll();
        Set<PermissionModel> permissionModelSet = new HashSet<>(permissionModels);
        return permissionModelSet;
    }
}
