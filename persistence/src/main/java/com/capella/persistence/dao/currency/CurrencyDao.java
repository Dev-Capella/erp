package com.capella.persistence.dao.currency;

import com.capella.domain.model.currency.CurrencyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyDao extends JpaRepository<CurrencyModel, Long> {
    CurrencyModel getByCode(String code);
    List<CurrencyModel> findAll();
}
