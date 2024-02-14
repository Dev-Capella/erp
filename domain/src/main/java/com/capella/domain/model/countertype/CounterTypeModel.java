package com.capella.domain.model.countertype;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.SubSeriesTypeRequired;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = DomainConstant.COUNTER_TYPE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.COUNTER_TYPE_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.COUNTER_TYPE_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class CounterTypeModel extends CodeBasedModel {
    private String longText;
    private String shortText;
    private String searchText;
    private Boolean provisionalCounterAllowed;
    private Boolean defaultCounterAllowed;
    private BigDecimal counterTypeLength;
    @Enumerated(EnumType.STRING)
    private SubSeriesTypeRequired subSeriesTypeRequired;
}
