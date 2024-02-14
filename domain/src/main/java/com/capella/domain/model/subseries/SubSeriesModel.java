package com.capella.domain.model.subseries;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.counter.CounterModel;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = DomainConstant.SUB_SERIES_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.SUB_SERIES_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.SUB_SERIES_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class SubSeriesModel extends CodeBasedModel {

    public static final String SUB_SERIES_RELATION = "sub_series_id";

    private String longText;

    private String shortText;

    private String searchText;

    private BigDecimal lastUsedNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="counters_sub_series",
            joinColumns = @JoinColumn(name = SUB_SERIES_RELATION), inverseJoinColumns = @JoinColumn(name = CounterModel.COUNTER_RELATION))
    private CounterModel counter;
}
