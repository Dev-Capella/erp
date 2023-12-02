package com.capella.domain.data.unitofmeasure;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.enums.UnitOfMeasureType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UnitOfMeasureData extends BaseDescriptionData {
    private UnitOfMeasureType unitOfMeasureType;
}
