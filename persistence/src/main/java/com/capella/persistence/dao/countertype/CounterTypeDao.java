package com.capella.persistence.dao.countertype;

import com.capella.domain.model.countertype.CounterTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterTypeDao extends JpaRepository<CounterTypeModel, Long> {
    CounterTypeModel getByCode(String code);
    List<CounterTypeModel> findAll();
}
