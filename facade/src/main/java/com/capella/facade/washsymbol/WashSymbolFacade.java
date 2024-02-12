package com.capella.facade.washsymbol;

import com.capella.domain.data.washsymbol.WashSymbolData;

import java.util.Set;

public interface WashSymbolFacade {
    void save(WashSymbolData washSymbolData);
    Set<WashSymbolData> getAll();
    WashSymbolData get(String code);
    void delete(String code);
}
