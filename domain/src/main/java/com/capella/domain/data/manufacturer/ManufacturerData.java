package com.capella.domain.data.manufacturer;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.media.MediaData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ManufacturerData extends BaseDescriptionData {
    private String name;
    private MediaData media;
}
