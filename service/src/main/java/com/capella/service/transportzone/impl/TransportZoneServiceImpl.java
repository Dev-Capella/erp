package com.capella.service.transportzone.impl;

import com.capella.domain.model.transportzone.TransportZoneModel;
import com.capella.persistence.dao.transportzone.TransportZoneDao;
import com.capella.service.transportzone.TransportZoneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class TransportZoneServiceImpl implements TransportZoneService {

    private final TransportZoneDao transportZoneDao;

    @Override
    public TransportZoneModel getTransportZoneModel(String code) {
        var transportZoneModel = transportZoneDao.getByCode(code);
        return transportZoneModel;
    }

    @Override
    public Set<TransportZoneModel> getTransportZoneModels() {
        List<TransportZoneModel> transportZoneModels = transportZoneDao.findAll();
        Set<TransportZoneModel> transportZoneModelSet = new HashSet<>(transportZoneModels);
        return transportZoneModelSet;
    }
}
