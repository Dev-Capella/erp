package com.capella.facade.compositioncomponent;

import com.capella.domain.data.compositioncomponent.CompositionComponentData;

import java.util.Set;

public interface CompositionComponentFacade {
    void save(CompositionComponentData compositionComponentData);
    Set<CompositionComponentData> getAll();
    CompositionComponentData get(String code);
    void delete(String code);
}
