package com.capella.domain.model.itemsubcode;

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
@Table(name = "ItemSubCode")
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
            joinColumns = @JoinColumn(name = ITEM_SUBCODE_RELATION), inverseJoinColumns = @JoinColumn(name = "item_type_id"))
    private ItemTypeModel itemType;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemSubCodeCheckTypeModel itemSubCodeCheckType;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserGenericGroupModel userGenericGroup;
}
