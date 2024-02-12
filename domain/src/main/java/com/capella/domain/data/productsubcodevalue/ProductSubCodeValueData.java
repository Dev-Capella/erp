package com.capella.domain.data.productsubcodevalue;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.data.usergenericgroupdetail.UserGenericGroupDetailData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ProductSubCodeValueData extends BaseDescriptionData {
    private String textValue;
    private BigDecimal numericValue;
    private ItemSubCodeData itemSubCode;
    private UserGenericGroupDetailData userGenericGroupDetail;
}
