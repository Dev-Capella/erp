package com.capella.domain.model.washsymbol;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.compositioncomponent.CompositionComponentModel;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.washsymbolcategory.WashSymbolCategoryModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.WASH_SYMBOL_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.WASH_SYMBOL_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.WASH_SYMBOL_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class WashSymbolModel extends CodeBasedModel {
    private String longText;
    private String shortText;
    private String searchText;
    @ManyToOne(fetch = FetchType.LAZY)
    private WashSymbolCategoryModel washSymbolCategory;
}
