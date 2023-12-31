package com.capella.domain.data.composition;

import com.capella.domain.data.base.BaseDescriptionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CompositionData extends BaseDescriptionData {
    private Boolean valid;
}
