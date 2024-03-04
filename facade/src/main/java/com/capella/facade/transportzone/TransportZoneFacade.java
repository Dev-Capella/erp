package com.capella.facade.transportzone;

import com.capella.domain.data.transportzone.TransportZoneData;

import java.util.Set;

public interface TransportZoneFacade {
    TransportZoneData save(TransportZoneData transportZoneData);
    Set<TransportZoneData> getAll();
    TransportZoneData get(String code);
    void delete(String code);
}
