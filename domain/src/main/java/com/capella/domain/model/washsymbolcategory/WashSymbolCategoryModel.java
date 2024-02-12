package com.capella.domain.model.washsymbolcategory;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.WASH_SYMBOL_CATEGORY_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.WASH_SYMBOL_CATEGORY_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.WASH_SYMBOL_CATEGORY_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class WashSymbolCategoryModel extends CodeBasedModel {
    private String longText;
    private String shortText;
    private String searchText;
}
