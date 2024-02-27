package com.capella.persistence.dao.country;

import com.capella.domain.model.country.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryDao extends JpaRepository<CountryModel, Long> {
    CountryModel getByCode(String code);

    List<CountryModel> findAll();
}
