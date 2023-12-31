package com.capella.service.usergenericgroup.impl;

import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;
import com.capella.persistence.dao.usergenericgroup.UserGenericGroupDao;
import com.capella.service.usergenericgroup.UserGenericGroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class UserGenericGroupServiceImpl implements UserGenericGroupService {
    private final UserGenericGroupDao userGenericGroupDao;
    @Override
    public UserGenericGroupModel getUserGenericGroupModel(String code) {
        var unitOfMeasureModel = userGenericGroupDao.getByCode(code);
        return unitOfMeasureModel;
    }

    @Override
    public Set<UserGenericGroupModel> getUserGenericGroupModels() {
        List<UserGenericGroupModel> userGenericGroupModels = userGenericGroupDao.findAll();
        Set<UserGenericGroupModel> userGenericGroupModelSet = new HashSet<>(userGenericGroupModels);
        return userGenericGroupModelSet;
    }
}
