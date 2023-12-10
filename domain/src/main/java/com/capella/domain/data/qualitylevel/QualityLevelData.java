package com.capella.domain.data.qualitylevel;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.itemtype.ItemTypeData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class QualityLevelData extends BaseDescriptionData {
    private int level;
    private ItemTypeData itemType;
}
