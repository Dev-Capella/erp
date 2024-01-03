package com.capella.persistence.dao.manufacturer;

import com.capella.domain.model.manufacturer.ManufacturerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerDao extends JpaRepository<ManufacturerModel, Long> {
    ManufacturerModel getByCode(String code);
    List<ManufacturerModel> findAll();
}
