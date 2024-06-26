package com.capella.domain.model.product;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.ConversionFactorType;
import com.capella.domain.model.composition.CompositionModel;
import com.capella.domain.model.costcategory.CostCategoryModel;
import com.capella.domain.model.costlevel.CostLevelModel;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.domain.model.manufacturer.ManufacturerModel;
import com.capella.domain.model.productiongroup.ProductionGroupModel;
import com.capella.domain.model.productsubcodevalue.ProductSubCodeValueModel;
import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = DomainConstant.PRODUCT_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.PRODUCT_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.PRODUCT_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class ProductModel extends CodeBasedModel {
    public static final String PRODUCT_RELATION = "product_id";

    private String longText;

    private String shortText;

    private String searchText;

    private BigDecimal conversionFactor;

    private BigDecimal multiplier;

    @Enumerated(EnumType.STRING)
    private ConversionFactorType conversionFactorType;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private UnitOfMeasureModel primaryUOM;

    @ManyToOne(fetch = FetchType.LAZY)
    private UnitOfMeasureModel costUOM;

    @ManyToOne(fetch = FetchType.LAZY)
    private UnitOfMeasureModel secondaryUOM;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="products_product_sub_code_values",
            joinColumns = @JoinColumn(name = PRODUCT_RELATION), inverseJoinColumns = @JoinColumn(name = ProductSubCodeValueModel.PRODUCT_SUB_CODE_VALUE_RELATION))
    private Set<ProductSubCodeValueModel> productSubCodeValues;

}
