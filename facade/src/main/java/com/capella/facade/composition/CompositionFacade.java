package com.capella.facade.composition;

import com.capella.domain.data.composition.CompositionData;
import com.capella.domain.data.compositiondetail.CompositionDetailData;
import com.capella.domain.data.itemsubcode.ItemSubCodeData;

import java.util.Set;

public interface CompositionFacade {
    void save(CompositionData compositionData);
    Set<CompositionData> getAll();
    CompositionData get(String code);
    void delete(String code);
    Set<CompositionDetailData> getCompositionDetailsByComposition(String code);
}
