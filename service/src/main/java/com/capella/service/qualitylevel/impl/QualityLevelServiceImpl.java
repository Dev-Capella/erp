package com.capella.service.qualitylevel.impl;

import com.capella.domain.model.qualitylevel.QualityLevelModel;
import com.capella.persistence.dao.qualitylevel.QualityLevelDao;
import com.capella.service.qualitylevel.QualityLevelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class QualityLevelServiceImpl implements QualityLevelService {

    private final QualityLevelDao qualityLevelDao;

    @Override
    public QualityLevelModel getQualityLevelModel(String code) {
        var qualityLevelModel = qualityLevelDao.getByCode(code);
        return qualityLevelModel;
    }
}
