package com.capella.facade.currency;

import com.capella.domain.data.currency.CurrencyData;

import java.util.Set;

public interface CurrencyFacade {
    void save(CurrencyData currencyData);
    Set<CurrencyData> getAll();
    CurrencyData get(String code);
    void delete(String code);
}
