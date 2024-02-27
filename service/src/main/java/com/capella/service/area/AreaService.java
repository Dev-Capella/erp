package com.capella.service.area;

import com.capella.domain.model.area.AreaModel;

import java.util.Set;

public interface AreaService {
    AreaModel getAreaModel(String code);
    Set<AreaModel> getAreaModels();
}
