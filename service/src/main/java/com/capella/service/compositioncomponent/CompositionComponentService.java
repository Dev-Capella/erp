package com.capella.service.compositioncomponent;

import com.capella.domain.model.compositioncomponent.CompositionComponentModel;

import java.util.Set;

public interface CompositionComponentService {
    CompositionComponentModel getCompositionComponentModel(String code);
    Set<CompositionComponentModel> getCompositionComponentModels();
}
