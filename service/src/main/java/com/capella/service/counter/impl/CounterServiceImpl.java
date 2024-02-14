package com.capella.service.counter.impl;

import com.capella.domain.model.counter.CounterModel;
import com.capella.persistence.dao.counter.CounterDao;
import com.capella.service.counter.CounterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class CounterServiceImpl implements CounterService {
    private final CounterDao counterDao;
    @Override
    public CounterModel getCounterModel(String code) {
        var counterModel = counterDao.getByCode(code);
        return counterModel;
    }

    @Override
    public Set<CounterModel> getCounterModels() {
        List<CounterModel> counterModels = counterDao.findAll();
        Set<CounterModel> counterModelSet = new HashSet<>(counterModels);
        return counterModelSet;
    }
}
