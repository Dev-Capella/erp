package com.capella.domain.data.itemtype;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.unitofmeasure.UnitOfMeasureData;
import com.capella.domain.enums.BaseUoMPackagingType;
import com.capella.domain.enums.ItemNature;
import com.capella.domain.enums.StatusAllowed;
import com.capella.domain.enums.Structure;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ItemTypeData extends BaseDescriptionData {
    private Boolean sellingType;
    private Boolean valid;
    private Boolean managedByBox;
    private Boolean handleComponentStatus;
    private Boolean qualityControlled;
    private Boolean lotControlled;
    private Boolean containerControlled;
    private Boolean elementControlled;
    private Boolean projectControlled;
    private Boolean statisticalGroupControlled;
    private Boolean costForStatisticalGroupControlled;
    private Boolean customerControlled;
    private Boolean supplierControlled;
    private Boolean packagingUnitControlled;
    private Boolean secondaryUnitControlled;
    private int maxCodeLength;
    private BigDecimal secondaryConversionFactor;
    private BigDecimal packagingConversionFactor;
    private BaseUoMPackagingType baseUoMPackagingType;
    private ItemNature itemNature;
    private StatusAllowed statusAllowed;
    private Structure structure;
    private UnitOfMeasureData primaryUOM;
    private UnitOfMeasureData secondaryUOM;
    private UnitOfMeasureData packagingUOM;
}
