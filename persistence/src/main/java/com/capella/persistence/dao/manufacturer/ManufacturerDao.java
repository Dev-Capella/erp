package com.capella.persistence.dao.manufacturer;

import com.capella.domain.model.manufacturer.ManufacturerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerDao extends JpaRepository<ManufacturerModel, Long> {
}
