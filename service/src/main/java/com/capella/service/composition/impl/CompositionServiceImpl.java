package com.capella.service.composition.impl;

import com.capella.domain.model.composition.CompositionModel;
import com.capella.persistence.dao.composition.CompositionDao;
import com.capella.service.composition.CompositionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class CompositionServiceImpl implements CompositionService {
    private final CompositionDao compositionDao;
    @Override
    public CompositionModel getCompositionModel(String code) {
        var compositionModel = compositionDao.getByCode(code);
        return compositionModel;
    }

    @Override
    public Set<CompositionModel> getCompositionModels() {
        List<CompositionModel> compositionModels = compositionDao.findAll();
        Set<CompositionModel> compositionModelSet = new HashSet<>(compositionModels);
        return compositionModelSet;
    }
}
