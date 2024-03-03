package com.capella.facade.country.impl;

import com.capella.domain.data.country.CountryData;
import com.capella.domain.model.country.CountryModel;
import com.capella.facade.country.CountryFacade;
import com.capella.service.country.CountryService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class CountryFacadeImpl implements CountryFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CountryService countryService;

    @Override
    public CountryData save(CountryData countryData) {
        CountryModel countryModel;
        if(countryData.isNew()){
            countryModel = modelMapper.map(countryData, CountryModel.class);
            countryModel.setCode(UUID.randomUUID().toString());
        }else{
            countryModel = countryService.getCountryModel(countryData.getCode());
            modelMapper.map(countryData, countryModel);
        }
        modelService.save(countryModel);
        return modelMapper.map(countryModel, CountryData.class);
    }

    @Override
    public Set<CountryData> getAll() {
        var countryModels = countryService.getCountryModels();
        return Set.of(modelMapper.map(countryModels, CountryData[].class));
    }

    @Override
    public CountryData get(String code) {
        var countryModel = countryService.getCountryModel(code);
        return modelMapper.map(countryModel,CountryData.class);
    }

    @Override
    public void delete(String code) {
        var countryModel = countryService.getCountryModel(code);
        modelService.remove(countryModel);
    }
}
