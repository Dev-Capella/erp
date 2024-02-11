package com.capella.persistence.dao.parameter;

import com.capella.domain.model.parameter.ParameterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParameterDao extends JpaRepository<ParameterModel, Long> {
    ParameterModel getByCode(String code);
    List<ParameterModel> findAll();
}
