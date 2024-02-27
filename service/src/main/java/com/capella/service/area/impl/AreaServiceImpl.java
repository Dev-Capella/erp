package com.capella.service.area.impl;

import com.capella.domain.model.area.AreaModel;
import com.capella.persistence.dao.area.AreaDao;
import com.capella.service.area.AreaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class AreaServiceImpl implements AreaService {

    private final AreaDao areaDao;
    @Override
    public AreaModel getAreaModel(String code) {
        var areaModel = areaDao.getByCode(code);
        return areaModel;
    }

    @Override
    public Set<AreaModel> getAreaModels() {
        List<AreaModel> areaModels = areaDao.findAll();
        Set<AreaModel> areaModelSet = new HashSet<>(areaModels);
        return areaModelSet;
    }
}
