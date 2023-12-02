package com.capella.persistence.dao.qualitylevel;

import com.capella.domain.model.qualitylevel.QualityLevelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualityLevelDao extends JpaRepository<QualityLevelModel, Long> {
    QualityLevelModel getByCode(String code);
}
