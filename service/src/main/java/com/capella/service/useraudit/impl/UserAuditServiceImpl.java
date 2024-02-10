package com.capella.service.useraudit.impl;

import com.capella.domain.model.useraudit.UserAuditModel;
import com.capella.persistence.dao.useraudit.UserAuditDao;
import com.capella.service.useraudit.UserAuditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class UserAuditServiceImpl implements UserAuditService {
    private final UserAuditDao userAuditDao;
    @Override
    public Set<UserAuditModel> getUserAuditModels() {
        List<UserAuditModel> userAuditModels = userAuditDao.findAll();
        Set<UserAuditModel> userAuditModelSet = new HashSet<>(userAuditModels);
        return userAuditModelSet;
    }
}
