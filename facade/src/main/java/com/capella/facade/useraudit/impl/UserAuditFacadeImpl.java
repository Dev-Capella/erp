package com.capella.facade.useraudit.impl;

import com.capella.domain.data.useraudit.UserAuditData;
import com.capella.facade.useraudit.UserAuditFacade;
import com.capella.service.useraudit.UserAuditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
@Slf4j
public class UserAuditFacadeImpl implements UserAuditFacade {
    protected final ModelMapper modelMapper;
    protected final UserAuditService userAuditService;
    @Override
    public Set<UserAuditData> getAll() {
        var userAuditModels = userAuditService.getUserAuditModels();
        return Set.of(modelMapper.map(userAuditModels, UserAuditData[].class));
    }
}
