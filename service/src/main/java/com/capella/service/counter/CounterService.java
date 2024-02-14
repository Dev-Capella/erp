package com.capella.service.counter;

import com.capella.domain.model.counter.CounterModel;

import java.util.Set;

public interface CounterService {
    CounterModel getCounterModel(String code);
    Set<CounterModel> getCounterModels();
}
