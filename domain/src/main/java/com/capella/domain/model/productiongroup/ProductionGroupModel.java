package com.capella.domain.model.productiongroup;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.PRODUCTION_GROUP_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.PRODUCTION_GROUP_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.PRODUCTION_GROUP_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class ProductionGroupModel extends CodeBasedModel {
    private String longText;
    private String shortText;
    private String searchText;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemTypeModel itemType;
}
