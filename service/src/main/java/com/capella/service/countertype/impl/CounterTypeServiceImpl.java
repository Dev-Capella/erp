package com.capella.service.countertype.impl;

import com.capella.domain.model.countertype.CounterTypeModel;
import com.capella.persistence.dao.countertype.CounterTypeDao;
import com.capella.service.countertype.CounterTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class CounterTypeServiceImpl implements CounterTypeService {
    private final CounterTypeDao counterTypeDao;
    @Override
    public CounterTypeModel getCounterTypeModel(String code) {
        var counterTypeModel = counterTypeDao.getByCode(code);
        return counterTypeModel;
    }

    @Override
    public Set<CounterTypeModel> getCounterTypeModels() {
        List<CounterTypeModel> counterTypeModels = counterTypeDao.findAll();
        Set<CounterTypeModel> counterTypeModelSet = new HashSet<>(counterTypeModels);
        return counterTypeModelSet;
    }
}
