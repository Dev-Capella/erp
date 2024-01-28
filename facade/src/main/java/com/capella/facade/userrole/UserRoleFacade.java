package com.capella.facade.userrole;

import com.capella.domain.data.userrole.UserRoleData;

import java.util.Set;

public interface UserRoleFacade {
    void save(UserRoleData userRoleData);
    Set<UserRoleData> getAll();
    UserRoleData get(String code);
    void delete(String code);
}
