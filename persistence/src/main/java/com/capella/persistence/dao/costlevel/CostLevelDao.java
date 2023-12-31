package com.capella.persistence.dao.costlevel;

import com.capella.domain.model.costlevel.CostLevelModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostLevelDao extends JpaRepository<CostLevelModel, Long> {
    CostLevelModel getByCode(String code);
    List<CostLevelModel> findAll();
}
