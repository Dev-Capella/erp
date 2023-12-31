package com.capella.persistence.dao.compositiondetail;

import com.capella.domain.model.compositiondetail.CompositionDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositionDetailDao extends JpaRepository<CompositionDetailModel, Long> {
    CompositionDetailModel getByCode(String code);
}
