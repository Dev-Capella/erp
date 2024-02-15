package com.capella.persistence.dao.cronjob;

import com.capella.domain.model.cronjob.CronJobModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CronJobDao extends JpaRepository<CronJobModel, Long> {
    CronJobModel getByCode(String code);
    List<CronJobModel> findAll();
}
