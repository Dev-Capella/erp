package com.capella.persistence.dao.counter;

import com.capella.domain.model.counter.CounterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterDao extends JpaRepository<CounterModel, Long> {
    CounterModel getByCode(String code);
    List<CounterModel> findAll();
}
