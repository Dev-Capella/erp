package com.capella.persistence.dao.compositioncomponent;

import com.capella.domain.model.compositioncomponent.CompositionComponentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompositionComponentDao extends JpaRepository<CompositionComponentModel, Long> {
    CompositionComponentModel getByCode(String code);
    List<CompositionComponentModel> findAll();
}
