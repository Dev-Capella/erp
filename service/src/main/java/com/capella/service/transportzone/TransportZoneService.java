package com.capella.service.transportzone;

import com.capella.domain.model.transportzone.TransportZoneModel;

import java.util.Set;

public interface TransportZoneService {
    TransportZoneModel getTransportZoneModel(String code);
    Set<TransportZoneModel> getTransportZoneModels();
}
