package com.capella.service.country.impl;

import com.capella.domain.model.country.CountryModel;
import com.capella.persistence.dao.country.CountryDao;
import com.capella.service.country.CountryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    @Override
    public CountryModel getCountryModel(String code) {
        var countryModel = countryDao.getByCode(code);
        return countryModel;
    }

    @Override
    public Set<CountryModel> getCountryModels() {
        List<CountryModel> countryModels = countryDao.findAll();
        Set<CountryModel> countryModelSet = new HashSet<>(countryModels);
        return countryModelSet;
    }
}
