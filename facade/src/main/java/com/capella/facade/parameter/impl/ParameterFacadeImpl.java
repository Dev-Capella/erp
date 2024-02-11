package com.capella.facade.parameter.impl;

import com.capella.domain.data.parameter.ParameterData;
import com.capella.domain.model.parameter.ParameterModel;
import com.capella.facade.parameter.ParameterFacade;
import com.capella.service.model.ModelService;
import com.capella.service.parameter.ParameterService;
import com.capella.service.util.ServiceUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class ParameterFacadeImpl implements ParameterFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ParameterService parameterService;
    @Override
    public void save(ParameterData parameterData) {
        ParameterModel parameterModel;
        if(parameterData.isNew()){
            parameterModel = modelMapper.map(parameterData, ParameterModel.class);
            ServiceUtils.generateCodeIfMissing(parameterModel);
        }else{
            parameterModel = parameterService.getParameterModel(parameterData.getCode());
            modelMapper.map(parameterData, parameterModel);
        }
        modelService.save(parameterModel);
    }

    @Override
    public Set<ParameterData> getAll() {
        var parameterModels = parameterService.getParameterModels();
        return Set.of(modelMapper.map(parameterModels, ParameterData[].class));
    }

    @Override
    public ParameterData get(String code) {
        var parameterModel = parameterService.getParameterModel(code);
        return modelMapper.map(parameterModel,ParameterData.class);
    }

    @Override
    public void delete(String code) {
        var parameterModel = parameterService.getParameterModel(code);
        modelService.remove(parameterModel);
    }
}
