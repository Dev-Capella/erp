package com.capella.domain.data.itemsubcodechecktype;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.enums.CheckType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ItemSubCodeCheckTypeData extends BaseDescriptionData {
    private String relatedItem;

    @Enumerated(EnumType.STRING)
    private CheckType checkType;

    private String policy;
}
