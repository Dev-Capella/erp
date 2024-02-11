package com.capella.domain.model.itemtype;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.BaseUoMPackagingType;
import com.capella.domain.enums.ItemNature;
import com.capella.domain.enums.StatusAllowed;
import com.capella.domain.enums.Structure;
import com.capella.domain.model.bomitemsubcode.BoMItemSubCodeModel;
import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.qualitylevel.QualityLevelModel;
import com.capella.domain.model.routingitemsubcode.RoutingItemSubCodeModel;
import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = DomainConstant.ITEM_TYPE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.ITEM_TYPE_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.ITEM_TYPE_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class ItemTypeModel extends CodeBasedModel {

    public static final String ITEM_TYPE_RELATION = "item_type_id";

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

    private int maxCodeLength;

    @Enumerated(EnumType.STRING)
    private BaseUoMPackagingType baseUoMPackagingType;

    @Enumerated(EnumType.STRING)
    private ItemNature itemNature;

    @Enumerated(EnumType.STRING)
    private StatusAllowed statusAllowed;

    @Enumerated(EnumType.STRING)
    private Structure structure;

    @ManyToOne(fetch = FetchType.LAZY)
    private UnitOfMeasureModel primaryUOM;

    @ManyToOne(fetch = FetchType.LAZY)
    private UnitOfMeasureModel secondaryUOM;

    @ManyToOne(fetch = FetchType.LAZY)
    private UnitOfMeasureModel packagingUOM;

    @OneToMany
    @JoinTable(name="item_types_item_subcodes",
                joinColumns = @JoinColumn(name = ITEM_TYPE_RELATION), inverseJoinColumns = @JoinColumn(name = ItemSubCodeModel.ITEM_SUBCODE_RELATION))
    private Set<ItemSubCodeModel> itemSubCodes;

    @OneToMany
    @JoinTable(name="item_types_quality_levels",
            joinColumns = @JoinColumn(name = ITEM_TYPE_RELATION), inverseJoinColumns = @JoinColumn(name = QualityLevelModel.QUALITY_LEVEL_RELATION))
    private Set<QualityLevelModel> qualityLevels;

    @OneToMany
    @JoinTable(name="item_types_routing_item_subcodes",
            joinColumns = @JoinColumn(name = ITEM_TYPE_RELATION), inverseJoinColumns = @JoinColumn(name = RoutingItemSubCodeModel.ROUTING_ITEM_SUBCODE_RELATION))
    private Set<RoutingItemSubCodeModel> routingItemSubCodes;

    @OneToMany
    @JoinTable(name="item_types_bom_item_subcodes",
            joinColumns = @JoinColumn(name = ITEM_TYPE_RELATION), inverseJoinColumns = @JoinColumn(name = BoMItemSubCodeModel.BoM_ITEM_SUBCODE_RELATION))
    private Set<BoMItemSubCodeModel> bomItemSubCodes;

}
