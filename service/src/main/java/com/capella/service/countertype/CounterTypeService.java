package com.capella.service.countertype;

import com.capella.domain.model.countertype.CounterTypeModel;

import java.util.Set;

public interface CounterTypeService {
    CounterTypeModel getCounterTypeModel(String code);
    Set<CounterTypeModel> getCounterTypeModels();
}
