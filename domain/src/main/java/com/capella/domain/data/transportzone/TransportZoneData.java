package com.capella.domain.data.transportzone;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.country.CountryData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class TransportZoneData extends BaseDescriptionData {
    private CountryData country;
}
