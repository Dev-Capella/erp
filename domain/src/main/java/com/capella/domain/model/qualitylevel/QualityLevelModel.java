package com.capella.domain.model.qualitylevel;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.QUALITY_LEVEL_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.QUALITY_LEVEL_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.QUALITY_LEVEL_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class QualityLevelModel extends CodeBasedModel {

    public static final String QUALITY_LEVEL_RELATION = "quality_level_id";

    private int level;

    private String longText;

    private String shortText;

    private String searchText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="item_types_quality_levels",
            joinColumns = @JoinColumn(name = QUALITY_LEVEL_RELATION), inverseJoinColumns = @JoinColumn(name = ItemTypeModel.ITEM_TYPE_RELATION))
    private ItemTypeModel itemType;
}
