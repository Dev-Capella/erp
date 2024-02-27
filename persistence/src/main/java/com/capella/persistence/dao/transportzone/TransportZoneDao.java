package com.capella.persistence.dao.transportzone;

import com.capella.domain.model.transportzone.TransportZoneModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportZoneDao extends JpaRepository<TransportZoneModel, Long> {
    TransportZoneModel getByCode(String code);

    List<TransportZoneModel> findAll();
}
