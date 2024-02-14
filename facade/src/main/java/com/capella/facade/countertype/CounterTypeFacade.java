package com.capella.facade.countertype;

import com.capella.domain.data.countertype.CounterTypeData;

import java.util.Set;

public interface CounterTypeFacade {
    void save(CounterTypeData counterTypeData);
    Set<CounterTypeData> getAll();
    CounterTypeData get(String code);
    void delete(String code);
}
