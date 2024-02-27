package com.capella.service.country;

import com.capella.domain.model.country.CountryModel;

import java.util.Set;

public interface CountryService {
    CountryModel getCountryModel(String code);
    Set<CountryModel> getCountryModels();
}
