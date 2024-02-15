package com.capella.service.cronjob.impl;

import com.capella.domain.model.cronjob.CronJobModel;
import com.capella.persistence.dao.cronjob.CronJobDao;
import com.capella.service.cronjob.CronJobService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class CronJobServiceImpl implements CronJobService {
    private final CronJobDao cronJobDao;
    @Override
    public CronJobModel getCronJobModel(String code) {
        var cronJobModel = cronJobDao.getByCode(code);
        return cronJobModel;
    }

    @Override
    public Set<CronJobModel> getCronJobModels() {
        List<CronJobModel> cronJobModels = cronJobDao.findAll();
        Set<CronJobModel> cronJobModelSet = new HashSet<>(cronJobModels);
        return cronJobModelSet;
    }
}
