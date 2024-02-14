package com.capella.domain.model.currency;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.CounterUpdateCriteria;
import com.capella.domain.enums.RoundingCriteriaType;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = DomainConstant.CURRENCY_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.CURRENCY_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.CURRENCY_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class CurrencyModel extends CodeBasedModel {

    private String longText;

    private String shortText;

    private String searchText;

    @Enumerated(EnumType.STRING)
    private RoundingCriteriaType roundingCriteriaType;

    private Integer numberOfDecimal;

    private BigDecimal divisorForExchangeRate;

    @Enumerated(EnumType.STRING)
    private RoundingCriteriaType taxRoundingCriteriaType;

    private Integer taxNumberOfDecimal;

}
