package com.capella.domain.data.currency;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.enums.RoundingCriteriaType;
import com.capella.domain.enums.SubSeriesTypeRequired;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CurrencyData extends BaseDescriptionData {
    private RoundingCriteriaType roundingCriteriaType;
    private Integer numberOfDecimal;
    private BigDecimal divisorForExchangeRate;
    private RoundingCriteriaType taxRoundingCriteriaType;
    private Integer taxNumberOfDecimal;
}
