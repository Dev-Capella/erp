package com.capella.service.cronjob;

import com.capella.domain.model.cronjob.CronJobModel;

import java.util.Set;

public interface CronJobService {
    CronJobModel getCronJobModel(String code);
    Set<CronJobModel> getCronJobModels();
}
