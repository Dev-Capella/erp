package com.capella.domain.data.compositiondetail;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.composition.CompositionData;
import com.capella.domain.data.compositioncomponent.CompositionComponentData;
import com.capella.domain.enums.CompositionUseType;
import com.capella.domain.enums.SubComposition;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CompositionDetailData extends BaseDescriptionData {
    @Enumerated(EnumType.STRING)
    private SubComposition subComposition;
    @Enumerated(EnumType.STRING)
    private CompositionUseType useType;
    private int sequenceNumber;
    private BigDecimal percentage;
    private CompositionData composition;
    private CompositionComponentData compositionComponent;
}
