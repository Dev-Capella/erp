package com.capella.domain.data.countertype;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.enums.SubSeriesTypeRequired;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CounterTypeData extends BaseDescriptionData {
    private Boolean provisionalCounterAllowed;
    private Boolean defaultCounterAllowed;
    private BigDecimal counterTypeLength;
    private SubSeriesTypeRequired subSeriesTypeRequired;
}
