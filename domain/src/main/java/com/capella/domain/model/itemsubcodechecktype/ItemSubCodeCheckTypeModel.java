package com.capella.domain.model.itemsubcodechecktype;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.CheckType;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = DomainConstant.ITEM_SUB_CODE_CHECK_TYPE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.ITEM_SUB_CODE_CHECK_TYPE_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.ITEM_SUB_CODE_CHECK_TYPE_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class ItemSubCodeCheckTypeModel extends CodeBasedModel {

    public static final String ITEM_SUB_CODE_CHECK_TYPE_RELATION = "item_sub_code_check_type_id";

    private String longText;

    private String shortText;

    private String searchText;

    private String relatedItem;

    @Enumerated(EnumType.STRING)
    private CheckType checkType;
    
    private String policy;
}
