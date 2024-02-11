package com.capella.service.parameter;

import com.capella.domain.model.parameter.ParameterModel;

import java.util.Set;

public interface ParameterService {
    ParameterModel getParameterModel(String code);
    Set<ParameterModel> getParameterModels();
}
