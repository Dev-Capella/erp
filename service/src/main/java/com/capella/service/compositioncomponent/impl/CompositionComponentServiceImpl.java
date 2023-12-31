package com.capella.service.compositioncomponent.impl;

import com.capella.domain.model.compositioncomponent.CompositionComponentModel;
import com.capella.persistence.dao.compositioncomponent.CompositionComponentDao;
import com.capella.service.compositioncomponent.CompositionComponentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class CompositionComponentServiceImpl implements CompositionComponentService {
    private final CompositionComponentDao compositionComponentDao;
    @Override
    public CompositionComponentModel getCompositionComponentModel(String code) {
        var compositionComponentModel = compositionComponentDao.getByCode(code);
        return compositionComponentModel;
    }

    @Override
    public Set<CompositionComponentModel> getCompositionComponentModels() {
        List<CompositionComponentModel> compositionComponentModels = compositionComponentDao.findAll();
        Set<CompositionComponentModel> compositionComponentModelSet = new HashSet<>(compositionComponentModels);
        return compositionComponentModelSet;
    }
}
