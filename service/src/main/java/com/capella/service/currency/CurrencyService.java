package com.capella.service.currency;

import com.capella.domain.model.currency.CurrencyModel;

import java.util.Set;

public interface CurrencyService {
    CurrencyModel getCurrencyModel(String code);
    Set<CurrencyModel> getCurrencyModels();
}
