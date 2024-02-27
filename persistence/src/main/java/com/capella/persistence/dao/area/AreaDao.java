package com.capella.persistence.dao.area;

import com.capella.domain.model.area.AreaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaDao extends JpaRepository<AreaModel, Long> {
    AreaModel getByCode(String code);

    List<AreaModel> findAll();
}
