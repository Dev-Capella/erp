package com.capella.service.composition;

import com.capella.domain.model.composition.CompositionModel;

import java.util.Set;

public interface CompositionService {
    CompositionModel getCompositionModel(String code);
    Set<CompositionModel> getCompositionModels();
}
