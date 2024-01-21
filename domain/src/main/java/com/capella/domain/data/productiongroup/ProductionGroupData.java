package com.capella.domain.data.productiongroup;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.itemtype.ItemTypeData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ProductionGroupData extends BaseDescriptionData {
    private ItemTypeData itemType;
}
