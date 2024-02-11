package com.capella.domain.model.routingitemsubcode;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.ROUTING_ITEM_SUB_CODE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.ROUTING_ITEM_SUB_CODE_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.ROUTING_ITEM_SUB_CODE_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
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
            joinColumns = @JoinColumn(name = ROUTING_ITEM_SUBCODE_RELATION), inverseJoinColumns = @JoinColumn(name = ItemTypeModel.ITEM_TYPE_RELATION))
    private ItemTypeModel itemType;

}
