package com.capella.domain.model.itemsubcode;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.ItemSubCodeDataType;
import com.capella.domain.enums.ItemSubCodeType;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemsubcodechecktype.ItemSubCodeCheckTypeModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.ITEM_SUB_CODE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.ITEM_SUB_CODE_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.ITEM_SUB_CODE_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class ItemSubCodeModel extends CodeBasedModel {

    public static final String ITEM_SUBCODE_RELATION = "item_subcode_id";

    private int position;

    private int length;

    private Boolean mandatory;

    private String longText;

    private String shortText;

    private String searchText;

    private char outputSeparator;

    private Boolean wareHouseManagement;

    private Boolean excludedCostManagement;

    @Enumerated(EnumType.STRING)
    private ItemSubCodeDataType itemSubCodeDataType;

    @Enumerated(EnumType.STRING)
    private ItemSubCodeType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="item_types_item_subcodes",
            joinColumns = @JoinColumn(name = ITEM_SUBCODE_RELATION), inverseJoinColumns = @JoinColumn(name = ItemTypeModel.ITEM_TYPE_RELATION))
    private ItemTypeModel itemType;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemSubCodeCheckTypeModel itemSubCodeCheckType;

    private String groupTypeCode;

}
