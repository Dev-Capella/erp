package com.capella.domain.data.qualitylevel;

import com.capella.domain.data.base.BaseDescriptionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class QualityLevelData extends BaseDescriptionData {
    private int level;
}
