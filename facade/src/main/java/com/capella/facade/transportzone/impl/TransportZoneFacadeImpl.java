package com.capella.facade.transportzone.impl;

import com.capella.domain.data.transportzone.TransportZoneData;
import com.capella.domain.model.country.CountryModel;
import com.capella.domain.model.transportzone.TransportZoneModel;
import com.capella.facade.transportzone.TransportZoneFacade;
import com.capella.service.country.CountryService;
import com.capella.service.model.ModelService;
import com.capella.service.transportzone.TransportZoneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class TransportZoneFacadeImpl implements TransportZoneFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CountryService countryService;
    protected final TransportZoneService transportZoneService;

    @Override
    public TransportZoneData save(TransportZoneData transportZoneData) {
        TransportZoneModel transportZoneModel;
        if(transportZoneData.isNew()){
            transportZoneModel = modelMapper.map(transportZoneData, TransportZoneModel.class);
            transportZoneModel.setCode(UUID.randomUUID().toString());
        }else{
            transportZoneModel = transportZoneService.getTransportZoneModel(transportZoneData.getCode());
            modelMapper.map(transportZoneData, transportZoneModel);
        }
        CountryModel countryModel = null;
        if(Objects.nonNull(transportZoneData.getCountry())){
            countryModel = countryService.getCountryModel(transportZoneData.getCountry().getCode());
        }
        transportZoneModel.setCountry(countryModel);
        modelService.save(transportZoneModel);
        return modelMapper.map(transportZoneModel, TransportZoneData.class);
    }

    @Override
    public Set<TransportZoneData> getAll() {
        var transportZoneModels = transportZoneService.getTransportZoneModels();
        return Set.of(modelMapper.map(transportZoneModels, TransportZoneData[].class));
    }

    @Override
    public TransportZoneData get(String code) {
        var transportZoneModel = transportZoneService.getTransportZoneModel(code);
        return modelMapper.map(transportZoneModel,TransportZoneData.class);
    }

    @Override
    public void delete(String code) {
        var transportZoneModel = transportZoneService.getTransportZoneModel(code);
        modelService.remove(transportZoneModel);
    }
}
