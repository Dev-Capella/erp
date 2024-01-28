package com.capella.service.userrole;

import com.capella.domain.model.userrole.UserRoleModel;

import java.util.Set;

public interface UserRoleService {
    UserRoleModel getUserRoleModel(String code);
    Set<UserRoleModel> getUserRoleModels();
}
