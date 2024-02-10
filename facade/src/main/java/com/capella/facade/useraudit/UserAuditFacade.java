package com.capella.facade.useraudit;

import com.capella.domain.data.useraudit.UserAuditData;

import java.util.Set;

public interface UserAuditFacade {
    Set<UserAuditData> getAll();
}
