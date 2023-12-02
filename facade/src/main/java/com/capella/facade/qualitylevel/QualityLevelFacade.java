package com.capella.facade.qualitylevel;

import com.capella.domain.data.qualitylevel.QualityLevelData;

public interface QualityLevelFacade {
    void save(QualityLevelData qualityLevelData);
    void delete(String code);
}
