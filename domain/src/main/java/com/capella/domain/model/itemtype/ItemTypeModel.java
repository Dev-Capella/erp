package com.capella.domain.model.itemtype;

import com.capella.domain.enums.BaseUoMPackagingType;
import com.capella.domain.enums.ItemNature;
import com.capella.domain.enums.StatusAllowed;
import com.capella.domain.enums.Structure;
import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.qualitylevel.QualityLevelModel;
import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "ItemType")
@Getter
public class ItemTypeModel extends CodeBasedModel {

    @Enumerated(EnumType.STRING)
    private ItemNature itemNature;

    @Enumerated(EnumType.STRING)
    private StatusAllowed statusAllowed;

    @Enumerated(EnumType.STRING)
    private Structure structure;

    private Boolean sellingType;

    private Boolean valid;

    private Boolean managedByBox;

    private Boolean handleComponentStatus;

    private String longText;

    private String shortText;

    private String searchText;

    private Boolean qualityControlled;

    private Boolean lotControlled;

    private Boolean containerControlled;

    private Boolean elementControlled;

    private Boolean projectControlled;

    private Boolean statisticalGroupControlled;

    private Boolean costForStatisticalGroupControlled;

    private Boolean customerControlled;

    private Boolean supplierControlled;

    @ManyToOne
    private UnitOfMeasureModel primaryUOM;

    private Boolean secondaryUnitControlled;

    @ManyToOne
    private UnitOfMeasureModel secondaryUOM;

    private BigDecimal secondaryConversionFactor;

    private Boolean packagingUnitControlled;

    @OneToMany
    private Set<ItemSubCodeModel> itemSubCode;

    @OneToMany
    private Set<QualityLevelModel> qualityLevel;

    @Enumerated(EnumType.STRING)
    private BaseUoMPackagingType baseUoMPackagingType;

    private BigDecimal packagingConversionFactor;

}
