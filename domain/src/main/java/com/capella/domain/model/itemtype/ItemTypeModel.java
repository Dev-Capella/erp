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

    private BigDecimal secondaryConversionFactor;

    private Boolean packagingUnitControlled;

    private Boolean secondaryUnitControlled;

    private BigDecimal packagingConversionFactor;

    @Enumerated(EnumType.STRING)
    private BaseUoMPackagingType baseUoMPackagingType;

    @Enumerated(EnumType.STRING)
    private ItemNature itemNature;

    @Enumerated(EnumType.STRING)
    private StatusAllowed statusAllowed;

    @Enumerated(EnumType.STRING)
    private Structure structure;

    @ManyToOne
    private UnitOfMeasureModel primaryUOM;

    @ManyToOne
    private UnitOfMeasureModel secondaryUOM;

    @OneToMany
    private Set<ItemSubCodeModel> itemSubCode;

    @OneToMany
    private Set<QualityLevelModel> qualityLevel;


    public void setSellingType(Boolean sellingType) {
        this.sellingType = sellingType;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public void setManagedByBox(Boolean managedByBox) {
        this.managedByBox = managedByBox;
    }

    public void setHandleComponentStatus(Boolean handleComponentStatus) {
        this.handleComponentStatus = handleComponentStatus;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public void setQualityControlled(Boolean qualityControlled) {
        this.qualityControlled = qualityControlled;
    }

    public void setLotControlled(Boolean lotControlled) {
        this.lotControlled = lotControlled;
    }

    public void setContainerControlled(Boolean containerControlled) {
        this.containerControlled = containerControlled;
    }

    public void setElementControlled(Boolean elementControlled) {
        this.elementControlled = elementControlled;
    }

    public void setProjectControlled(Boolean projectControlled) {
        this.projectControlled = projectControlled;
    }

    public void setStatisticalGroupControlled(Boolean statisticalGroupControlled) {
        this.statisticalGroupControlled = statisticalGroupControlled;
    }

    public void setCostForStatisticalGroupControlled(Boolean costForStatisticalGroupControlled) {
        this.costForStatisticalGroupControlled = costForStatisticalGroupControlled;
    }

    public void setCustomerControlled(Boolean customerControlled) {
        this.customerControlled = customerControlled;
    }

    public void setSupplierControlled(Boolean supplierControlled) {
        this.supplierControlled = supplierControlled;
    }

    public void setSecondaryConversionFactor(BigDecimal secondaryConversionFactor) {
        this.secondaryConversionFactor = secondaryConversionFactor;
    }

    public void setPackagingUnitControlled(Boolean packagingUnitControlled) {
        this.packagingUnitControlled = packagingUnitControlled;
    }

    public void setSecondaryUnitControlled(Boolean secondaryUnitControlled) {
        this.secondaryUnitControlled = secondaryUnitControlled;
    }

    public void setPackagingConversionFactor(BigDecimal packagingConversionFactor) {
        this.packagingConversionFactor = packagingConversionFactor;
    }

    public void setBaseUoMPackagingType(BaseUoMPackagingType baseUoMPackagingType) {
        this.baseUoMPackagingType = baseUoMPackagingType;
    }

    public void setItemNature(ItemNature itemNature) {
        this.itemNature = itemNature;
    }

    public void setStatusAllowed(StatusAllowed statusAllowed) {
        this.statusAllowed = statusAllowed;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public void setPrimaryUOM(UnitOfMeasureModel primaryUOM) {
        this.primaryUOM = primaryUOM;
    }

    public void setSecondaryUOM(UnitOfMeasureModel secondaryUOM) {
        this.secondaryUOM = secondaryUOM;
    }

    public void setItemSubCode(Set<ItemSubCodeModel> itemSubCode) {
        this.itemSubCode = itemSubCode;
    }

    public void setQualityLevel(Set<QualityLevelModel> qualityLevel) {
        this.qualityLevel = qualityLevel;
    }
}
