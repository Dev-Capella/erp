package com.capella.facade.country;

import com.capella.domain.data.country.CountryData;

import java.util.Set;

public interface CountryFacade {
    void save(CountryData countryData);
    Set<CountryData> getAll();
    CountryData get(String code);
    void delete(String code);
}
