package com.capella.persistence.dao.userrole;

import com.capella.domain.model.userrole.UserRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRoleDao extends JpaRepository<UserRoleModel, Long> {
    UserRoleModel getByCode(String code);
    List<UserRoleModel> findAll();
}
