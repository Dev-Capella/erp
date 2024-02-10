package com.capella.persistence.dao.useraudit;

import com.capella.domain.model.useraudit.UserAuditModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAuditDao extends JpaRepository<UserAuditModel, Long> {
    List<UserAuditModel> findAll();
}
