package com.capella.facade.compositiondetail;

import com.capella.domain.data.compositiondetail.CompositionDetailData;

public interface CompositionDetailFacade {
    void save(CompositionDetailData compositionDetailData);
    void delete(String code);
    CompositionDetailData get(String code);
}
