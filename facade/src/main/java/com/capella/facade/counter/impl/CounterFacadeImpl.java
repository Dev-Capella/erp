package com.capella.facade.counter.impl;

import com.capella.domain.data.counter.CounterData;
import com.capella.domain.data.subseries.SubSeriesData;
import com.capella.domain.model.counter.CounterModel;
import com.capella.domain.model.countertype.CounterTypeModel;
import com.capella.facade.counter.CounterFacade;
import com.capella.service.counter.CounterService;
import com.capella.service.countertype.CounterTypeService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class CounterFacadeImpl implements CounterFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CounterTypeService counterTypeService;
    protected final CounterService counterService;
    @Override
    public void save(CounterData counterData) {
        CounterModel counterModel;
        if(counterData.isNew()){
            counterModel = modelMapper.map(counterData, CounterModel.class);
            counterModel.setCode(UUID.randomUUID().toString());
        }else{
            counterModel = counterService.getCounterModel(counterData.getCode());
            modelMapper.map(counterData, counterModel);
        }
        CounterTypeModel counterType = null;
        if(Objects.nonNull(counterData.getCounterType())){
            counterType = counterTypeService.getCounterTypeModel(counterData.getCounterType().getCode());
        }
        counterModel.setCounterType(counterType);
        modelService.save(counterModel);
    }

    @Override
    public Set<CounterData> getAll() {
        var counterModels = counterService.getCounterModels();
        return Set.of(modelMapper.map(counterModels, CounterData[].class));
    }

    @Override
    public CounterData get(String code) {
        var counterModel = counterService.getCounterModel(code);
        return modelMapper.map(counterModel,CounterData.class);
    }

    @Override
    public void delete(String code) {
        var counterModel = counterService.getCounterModel(code);
        modelService.remove(counterModel);
    }

    @Override
    public Set<SubSeriesData> getSubSeriesByCounter(String code) {
        var counterModel = counterService.getCounterModel(code);
        var subSeriesModels = counterModel.getSubSeries();
        return Set.of(modelMapper.map(subSeriesModels, SubSeriesData[].class));
    }
}
