package com.capella.service.useraudit;

import com.capella.domain.model.useraudit.UserAuditModel;

import java.util.Set;

public interface UserAuditService {
    Set<UserAuditModel> getUserAuditModels();
}
