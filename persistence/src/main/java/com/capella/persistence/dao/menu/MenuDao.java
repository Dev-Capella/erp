package com.capella.persistence.dao.menu;

import com.capella.domain.model.menu.MenuModel;
import com.capella.domain.model.userrole.UserRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MenuDao extends JpaRepository<MenuModel, Long> {
    MenuModel getByCode(String code);
    List<MenuModel> getAllByRootOrderByQueueAsc(Boolean isRoot);
    Set<MenuModel> getAllByRootAndUserRolesInOrderByQueueAsc(Boolean root, Set<UserRoleModel> userRoles);
}
