package com.capella.service.compositiondetail.impl;

import com.capella.domain.model.compositiondetail.CompositionDetailModel;
import com.capella.persistence.dao.compositiondetail.CompositionDetailDao;
import com.capella.service.compositiondetail.CompositionDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CompositionDetailServiceImpl implements CompositionDetailService {
    private final CompositionDetailDao compositionDetailDao;
    @Override
    public CompositionDetailModel getCompositionDetailModel(String code) {
        var compositionDetailModel = compositionDetailDao.getByCode(code);
        return compositionDetailModel;
    }
}
