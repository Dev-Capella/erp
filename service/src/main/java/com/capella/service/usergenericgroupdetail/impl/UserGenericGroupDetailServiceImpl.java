package com.capella.service.usergenericgroupdetail.impl;

import com.capella.domain.model.compositiondetail.CompositionDetailModel;
import com.capella.domain.model.usergenericgroupdetail.UserGenericGroupDetailModel;
import com.capella.persistence.dao.compositiondetail.CompositionDetailDao;
import com.capella.persistence.dao.usergenericgroupdetail.UserGenericGroupDetailDao;
import com.capella.service.compositiondetail.CompositionDetailService;
import com.capella.service.usergenericgroupdetail.UserGenericGroupDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserGenericGroupDetailServiceImpl implements UserGenericGroupDetailService {
    private final UserGenericGroupDetailDao userGenericGroupDetailDao;
    @Override
    public UserGenericGroupDetailModel getUserGenericGroupDetailModel(String code) {
        var userGenericGroupDetailModel = userGenericGroupDetailDao.getByCode(code);
        return userGenericGroupDetailModel;
    }
}
