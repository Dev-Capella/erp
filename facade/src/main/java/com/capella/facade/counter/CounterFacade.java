package com.capella.facade.counter;

import com.capella.domain.data.counter.CounterData;
import com.capella.domain.data.subseries.SubSeriesData;

import java.util.Set;

public interface CounterFacade {
    void save(CounterData counterData);
    Set<CounterData> getAll();
    CounterData get(String code);
    void delete(String code);
    Set<SubSeriesData> getSubSeriesByCounter(String code);
}
