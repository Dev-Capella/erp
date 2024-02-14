package com.capella.facade.subseries.impl;

import com.capella.domain.data.subseries.SubSeriesData;
import com.capella.domain.model.subseries.SubSeriesModel;
import com.capella.facade.subseries.SubSeriesFacade;
import com.capella.service.counter.CounterService;
import com.capella.service.model.ModelService;
import com.capella.service.subseries.SubSeriesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class SubSeriesFacadeImpl implements SubSeriesFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CounterService counterService;
    protected final SubSeriesService subSeriesService;

    @Override
    public void save(SubSeriesData subSeriesData) {
        SubSeriesModel subSeriesModel;
        if(subSeriesData.isNew()){
            subSeriesModel = modelMapper.map(subSeriesData, SubSeriesModel.class);
            subSeriesModel.setCode(UUID.randomUUID().toString());
        }else{
            subSeriesModel = subSeriesService.getSubSeriesModel(subSeriesData.getCode());
            modelMapper.map(subSeriesData, subSeriesModel);
        }
        subSeriesModel.setCounter(counterService.getCounterModel(subSeriesData.getCounter().getCode()));
        modelService.save(subSeriesModel);
    }

    @Override
    public void delete(String code) {
        var subSeriesModel = subSeriesService.getSubSeriesModel(code);
        modelService.remove(subSeriesModel);
    }

    @Override
    public SubSeriesData get(String code) {
        var subSeriesModel = subSeriesService.getSubSeriesModel(code);
        return modelMapper.map(subSeriesModel, SubSeriesData.class);
    }
}
