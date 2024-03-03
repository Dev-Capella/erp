package com.capella.facade.area;

import com.capella.domain.data.area.AreaData;

import java.util.Set;

public interface AreaFacade {
    AreaData save(AreaData areaData);
    Set<AreaData> getAll();
    AreaData get(String code);
    void delete(String code);
}
