package com.capella.service.userrole.impl;

import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;
import com.capella.domain.model.userrole.UserRoleModel;
import com.capella.persistence.dao.userrole.UserRoleDao;
import com.capella.service.userrole.UserRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleDao userRoleDao;
    @Override
    public UserRoleModel getUserRoleModel(String code) {
        var userRoleModel = userRoleDao.getByCode(code);
        return userRoleModel;
    }

    @Override
    public Set<UserRoleModel> getUserRoleModels() {
        List<UserRoleModel> userRoleModels = userRoleDao.findAll();
        Set<UserRoleModel> userRoleModelSet = new HashSet<>(userRoleModels);
        return userRoleModelSet;
    }
}
