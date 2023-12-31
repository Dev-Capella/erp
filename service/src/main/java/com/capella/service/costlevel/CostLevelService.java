package com.capella.service.costlevel;

import com.capella.domain.model.costlevel.CostLevelModel;

import java.util.Set;

public interface CostLevelService {
    CostLevelModel getCostLevelModel(String code);
    Set<CostLevelModel> getCostLevelModels();
}
