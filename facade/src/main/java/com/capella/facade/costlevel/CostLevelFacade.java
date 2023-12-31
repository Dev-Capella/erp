package com.capella.facade.costlevel;

import com.capella.domain.data.costlevel.CostLevelData;

import java.util.Set;

public interface CostLevelFacade {
    void save(CostLevelData costLevelData);
    Set<CostLevelData> getAll();
    CostLevelData get(String code);
    void delete(String code);
}
