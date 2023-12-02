package com.capella.domain.data.unitofmeasure;

import com.capella.domain.data.base.BaseData;
import com.capella.domain.enums.UnitOfMeasureType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UnitOfMeasureData extends BaseData {
    private String longText;
    private String shortText;
    private String searchText;
    private UnitOfMeasureType unitOfMeasureType;
}
