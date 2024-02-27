package com.capella.persistence.dao.market;

import com.capella.domain.model.country.CountryModel;
import com.capella.domain.model.market.MarketModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketDao extends JpaRepository<MarketModel, Long> {
    MarketModel getByCode(String code);

    List<MarketModel> findAll();
}
