package com.capella.facade.parameter;

import com.capella.domain.data.parameter.ParameterData;

import java.util.Set;

public interface ParameterFacade {
    void save(ParameterData parameterData);
    Set<ParameterData> getAll();
    ParameterData get(String code);
    void delete(String code);
}
