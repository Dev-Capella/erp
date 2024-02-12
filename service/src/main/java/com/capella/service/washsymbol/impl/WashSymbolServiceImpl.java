package com.capella.service.washsymbol.impl;

import com.capella.domain.model.washsymbol.WashSymbolModel;
import com.capella.persistence.dao.washsymbol.WashSymbolDao;
import com.capella.service.washsymbol.WashSymbolService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class WashSymbolServiceImpl implements WashSymbolService {
    private final WashSymbolDao washSymbolDao;
    @Override
    public WashSymbolModel getWashSymbolModel(String code) {
        var washSymbolModel = washSymbolDao.getByCode(code);
        return washSymbolModel;
    }

    @Override
    public Set<WashSymbolModel> getWashSymbolModels() {
        List<WashSymbolModel> washSymbolModels = washSymbolDao.findAll();
        Set<WashSymbolModel> washSymbolModelSet = new HashSet<>(washSymbolModels);
        return washSymbolModelSet;
    }
}
