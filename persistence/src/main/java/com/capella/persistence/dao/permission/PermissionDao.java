package com.capella.persistence.dao.permission;

import com.capella.domain.model.permission.PermissionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<PermissionModel, Long> {
    PermissionModel getByCode(String code);
}
