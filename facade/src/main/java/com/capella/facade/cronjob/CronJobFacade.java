package com.capella.facade.cronjob;

import com.capella.domain.data.cronjob.CronJobData;

import java.util.Set;

public interface CronJobFacade {
    void save(CronJobData cronJobData);
    Set<CronJobData> getAll();
    CronJobData get(String code);
    void delete(String code);
}
