package com.capella.service.manufacturer;

import com.capella.domain.model.manufacturer.ManufacturerModel;

import java.util.Set;

public interface ManufacturerService {
    ManufacturerModel getManufacturerModel(String code);
    Set<ManufacturerModel> getManufacturerModels();
}
