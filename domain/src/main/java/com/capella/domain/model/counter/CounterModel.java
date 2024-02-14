package com.capella.domain.model.counter;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.CounterUpdateCriteria;
import com.capella.domain.enums.SubSeriesType;
import com.capella.domain.model.countertype.CounterTypeModel;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = DomainConstant.COUNTER_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.COUNTER_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.COUNTER_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class CounterModel extends CodeBasedModel {
    private String longText;
    private String shortText;
    private String searchText;
    private Boolean provisionalCounter;
    private Boolean defaultCounter;
    private Boolean subSeriesRequired;
    @Enumerated(EnumType.STRING)
    private SubSeriesType subSeriesType;
    private BigDecimal beginLimit;
    private BigDecimal finalLimit;
    private BigDecimal step;
    private String mask;
    private char outputSeparator;
    private BigDecimal counterWidth;
    private BigDecimal subSeriesWidth;
    private char prefix;
    private char suffix;
    private Boolean counterReset;
    @Enumerated(EnumType.STRING)
    private CounterUpdateCriteria updateCriteria;
    @ManyToOne(fetch = FetchType.LAZY)
    private CounterTypeModel counterType;
}
