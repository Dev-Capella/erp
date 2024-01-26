package com.capella.domain.model.product;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.composition.CompositionModel;
import com.capella.domain.model.costcategory.CostCategoryModel;
import com.capella.domain.model.costlevel.CostLevelModel;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.domain.model.manufacturer.ManufacturerModel;
import com.capella.domain.model.productiongroup.ProductionGroupModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = DomainConstant.PRODUCT_TABLE_NAME)
@Getter
public class ProductModel extends CodeBasedModel {
    public static final String PRODUCT_RELATION = "product_id";

    private String longText;

    private String shortText;

    private String searchText;

    private Boolean sellingItem;

    private Boolean purchaseOrderItem;

    private Boolean internalOrderItem;

    private Date initialDate;

    private Date finalDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private ManufacturerModel manufacturer;

    @ManyToOne(fetch = FetchType.LAZY)
    private CostCategoryModel costCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private CostLevelModel costLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductionGroupModel productionGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    private CompositionModel compositionModel;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemTypeModel itemType;

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public void setSellingItem(Boolean sellingItem) {
        this.sellingItem = sellingItem;
    }

    public void setPurchaseOrderItem(Boolean purchaseOrderItem) {
        this.purchaseOrderItem = purchaseOrderItem;
    }

    public void setInternalOrderItem(Boolean internalOrderItem) {
        this.internalOrderItem = internalOrderItem;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public void setManufacturer(ManufacturerModel manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCostCategory(CostCategoryModel costCategory) {
        this.costCategory = costCategory;
    }

    public void setCostLevel(CostLevelModel costLevel) {
        this.costLevel = costLevel;
    }

    public void setProductionGroup(ProductionGroupModel productionGroup) {
        this.productionGroup = productionGroup;
    }

    public void setCompositionModel(CompositionModel compositionModel) {
        this.compositionModel = compositionModel;
    }

    public void setItemType(ItemTypeModel itemType) {
        this.itemType = itemType;
    }
}
