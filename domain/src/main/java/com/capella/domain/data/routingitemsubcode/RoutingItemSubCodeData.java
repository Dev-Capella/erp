package com.capella.domain.data.routingitemsubcode;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.itemtype.ItemTypeData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class RoutingItemSubCodeData extends BaseDescriptionData {
    private int position;
    private int length;
    private char outputSeparator;
    private ItemTypeData itemType;
}
