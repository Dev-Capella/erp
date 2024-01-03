package com.capella.facade.manufacturer;

import com.capella.domain.data.manufacturer.ManufacturerData;

import java.util.Set;

public interface ManufacturerFacade {
    void save(ManufacturerData manufacturerData);
    Set<ManufacturerData> getAll();
    ManufacturerData get(String code);
    void delete(String code);
}
