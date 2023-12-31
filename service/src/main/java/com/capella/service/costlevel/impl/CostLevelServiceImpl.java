package com.capella.service.costlevel.impl;

import com.capella.domain.model.costlevel.CostLevelModel;
import com.capella.persistence.dao.costlevel.CostLevelDao;
import com.capella.service.costlevel.CostLevelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@AllArgsConstructor
@Slf4j
public class CostLevelServiceImpl implements CostLevelService {
    private final CostLevelDao costLevelDao;

    @Override
    public CostLevelModel getCostLevelModel(String code) {
        var costLevelModel = costLevelDao.getByCode(code);
        return costLevelModel;
    }

    @Override
    public Set<CostLevelModel> getCostLevelModels() {
        List<CostLevelModel> costLevelModels = costLevelDao.findAll();
        Set<CostLevelModel> costLevelModelSet = new HashSet<>(costLevelModels);
        return costLevelModelSet;
    }
}
