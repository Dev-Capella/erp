package com.capella.domain.data.product;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.composition.CompositionData;
import com.capella.domain.data.costcategory.CostCategoryData;
import com.capella.domain.data.costlevel.CostLevelData;
import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.data.manufacturer.ManufacturerData;
import com.capella.domain.data.productiongroup.ProductionGroupData;
import com.capella.domain.data.productsubcodevalue.ProductSubCodeValueData;
import com.capella.domain.data.unitofmeasure.UnitOfMeasureData;
import com.capella.domain.enums.ConversionFactorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ProductData extends BaseDescriptionData {

    private Boolean sellingItem;
    private Boolean purchaseOrderItem;
    private Boolean internalOrderItem;
    private Date initialDate;
    private Date finalDate;
    private BigDecimal conversionFactor;
    private BigDecimal multiplier;
    private ConversionFactorType conversionFactorType;
    private ManufacturerData manufacturer;
    private CostCategoryData costCategory;
    private CostLevelData costLevel;
    private ProductionGroupData productionGroup;
    private CompositionData composition;
    private ItemTypeData itemType;
    private UnitOfMeasureData primaryUOM;
    private UnitOfMeasureData costUOM;
    private UnitOfMeasureData secondaryUOM;
    private Set<ProductSubCodeValueData> productSubCodeValues;

}
