package com.capella.persistence.dao.composition;

import com.capella.domain.model.composition.CompositionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompositionDao extends JpaRepository<CompositionModel, Long> {
    CompositionModel getByCode(String code);

    List<CompositionModel> findAll();
}
