package com.capella.persistence.dao.subseries;

import com.capella.domain.model.subseries.SubSeriesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubSeriesDao extends JpaRepository<SubSeriesModel, Long> {
    SubSeriesModel getByCode(String code);
}
