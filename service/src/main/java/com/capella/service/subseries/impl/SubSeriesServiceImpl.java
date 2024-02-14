package com.capella.service.subseries.impl;

import com.capella.domain.model.subseries.SubSeriesModel;
import com.capella.persistence.dao.subseries.SubSeriesDao;
import com.capella.service.subseries.SubSeriesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SubSeriesServiceImpl implements SubSeriesService {
    private final SubSeriesDao subSeriesDao;
    @Override
    public SubSeriesModel getSubSeriesModel(String code) {
        var subSeriesModel = subSeriesDao.getByCode(code);
        return subSeriesModel;
    }
}
