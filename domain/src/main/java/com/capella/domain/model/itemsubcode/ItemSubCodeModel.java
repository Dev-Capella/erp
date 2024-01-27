package com.capella.domain.model.itemsubcode;

import com.capella.domain.enums.ItemSubCodeDataType;
import com.capella.domain.enums.ItemSubCodeType;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "ItemSubCode")
@Getter
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

    public void setPosition(int position) {
        this.position = position;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
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

    public void setOutputSeparator(char outputSeparator) {
        this.outputSeparator = outputSeparator;
    }

    public void setWareHouseManagement(Boolean wareHouseManagement) {
        this.wareHouseManagement = wareHouseManagement;
    }

    public void setExcludedCostManagement(Boolean excludedCostManagement) {
        this.excludedCostManagement = excludedCostManagement;
    }

    public void setItemSubCodeDataType(ItemSubCodeDataType itemSubCodeDataType) {
        this.itemSubCodeDataType = itemSubCodeDataType;
    }

    public void setType(ItemSubCodeType type) {
        this.type = type;
    }

    public void setItemType(ItemTypeModel itemType) {
        this.itemType = itemType;
    }
}
