package com.capella.domain.model.routingitemsubcode;

import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "RoutingItemSubCode")
@Getter
public class RoutingItemSubCodeModel extends CodeBasedModel {
    public static final String ROUTING_ITEM_SUBCODE_RELATION = "routing_item_subcode_id";

    private int position;
    private int length;
    private char outputSeparator;
    private String longText;
    private String shortText;
    private String searchText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="item_types_routing_item_subcodes",
            joinColumns = @JoinColumn(name = ROUTING_ITEM_SUBCODE_RELATION), inverseJoinColumns = @JoinColumn(name = "item_type_id"))
    private ItemTypeModel itemType;

    public void setPosition(int position) {
        this.position = position;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setOutputSeparator(char outputSeparator) {
        this.outputSeparator = outputSeparator;
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

    public void setItemType(ItemTypeModel itemType) {
        this.itemType = itemType;
    }
}
