package com.capella.domain.data.counter;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.countertype.CounterTypeData;
import com.capella.domain.enums.CounterUpdateCriteria;
import com.capella.domain.enums.SubSeriesType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CounterData extends BaseDescriptionData {
    private Boolean provisionalCounter;
    private Boolean defaultCounter;
    private Boolean subSeriesRequired;
    private SubSeriesType subSeriesType;
    private BigDecimal beginLimit;
    private BigDecimal finalLimit;
    private BigDecimal step;
    private String mask;
    private char outputSeparator;
    private BigDecimal counterWidth;
    private BigDecimal subSeriesWidth;
    private char prefix;
    private char suffix;
    private Boolean counterReset;
    private CounterUpdateCriteria updateCriteria;
    private CounterTypeData counterType;
}
