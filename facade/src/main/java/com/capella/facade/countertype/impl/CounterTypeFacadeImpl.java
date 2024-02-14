package com.capella.facade.countertype.impl;

import com.capella.domain.data.countertype.CounterTypeData;
import com.capella.domain.model.countertype.CounterTypeModel;
import com.capella.facade.countertype.CounterTypeFacade;
import com.capella.service.countertype.CounterTypeService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class CounterTypeFacadeImpl implements CounterTypeFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CounterTypeService counterTypeService;
    @Override
    public void save(CounterTypeData counterTypeData) {
        CounterTypeModel counterTypeModel;
        if(counterTypeData.isNew()){
            counterTypeModel = modelMapper.map(counterTypeData, CounterTypeModel.class);
            counterTypeModel.setCode(UUID.randomUUID().toString());
        }else{
            counterTypeModel = counterTypeService.getCounterTypeModel(counterTypeData.getCode());
            modelMapper.map(counterTypeData, counterTypeModel);
        }
        modelService.save(counterTypeModel);
    }

    @Override
    public Set<CounterTypeData> getAll() {
        var counterTypeModels = counterTypeService.getCounterTypeModels();
        return Set.of(modelMapper.map(counterTypeModels, CounterTypeData[].class));
    }

    @Override
    public CounterTypeData get(String code) {
        var counterTypeModel = counterTypeService.getCounterTypeModel(code);
        return modelMapper.map(counterTypeModel,CounterTypeData.class);
    }

    @Override
    public void delete(String code) {
        var counterTypeModel = counterTypeService.getCounterTypeModel(code);
        modelService.remove(counterTypeModel);
    }
}
