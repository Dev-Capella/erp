package com.capella.domain.data.subseries;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.counter.CounterData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class SubSeriesData extends BaseDescriptionData {
    private BigDecimal lastUsedNumber;
    private CounterData counter;
}
