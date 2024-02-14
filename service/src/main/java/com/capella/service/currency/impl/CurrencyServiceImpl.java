package com.capella.service.currency.impl;

import com.capella.domain.model.currency.CurrencyModel;
import com.capella.persistence.dao.currency.CurrencyDao;
import com.capella.service.currency.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyDao currencyDao;

    @Override
    public CurrencyModel getCurrencyModel(String code) {
        var currencyModel = currencyDao.getByCode(code);
        return currencyModel;
    }

    @Override
    public Set<CurrencyModel> getCurrencyModels() {
        List<CurrencyModel> currencyModels = currencyDao.findAll();
        Set<CurrencyModel> currencyModelSet = new HashSet<>(currencyModels);
        return currencyModelSet;
    }
}
