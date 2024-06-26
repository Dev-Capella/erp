package com.capella.domain.data.itemsubcode;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.itemsubcodechecktype.ItemSubCodeCheckTypeData;
import com.capella.domain.enums.ItemSubCodeDataType;
import com.capella.domain.enums.ItemSubCodeType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ItemSubCodeSummaryData extends BaseDescriptionData {
    private int position;
    private int length;
    private Boolean mandatory;
    private char outputSeparator;
    private Boolean wareHouseManagement;
    private Boolean excludedCostManagement;
    private ItemSubCodeDataType itemSubCodeDataType;
    private ItemSubCodeType type;
    private ItemSubCodeCheckTypeData itemSubCodeCheckType;
    private String groupTypeCode;
}
