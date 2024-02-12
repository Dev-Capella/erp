package com.capella.service.washsymbol;

import com.capella.domain.model.washsymbol.WashSymbolModel;

import java.util.Set;

public interface WashSymbolService {
    WashSymbolModel getWashSymbolModel(String code);
    Set<WashSymbolModel> getWashSymbolModels();
}
