package com.capella.service.parameter.impl;

import com.capella.domain.model.parameter.ParameterModel;
import com.capella.persistence.dao.parameter.ParameterDao;
import com.capella.service.parameter.ParameterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ParameterServiceImpl implements ParameterService {
    private final ParameterDao parameterDao;
    @Override
    public ParameterModel getParameterModel(String code) {
        var parameterModel = parameterDao.getByCode(code);
        return parameterModel;
    }

    @Override
    public Set<ParameterModel> getParameterModels() {
        List<ParameterModel> parameterModels = parameterDao.findAll();
        Set<ParameterModel> parameterModelSet = new HashSet<>(parameterModels);
        return parameterModelSet;
    }
}
