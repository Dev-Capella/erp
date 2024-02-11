package com.capella.domain.model.compositiondetail;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.CompositionUseType;
import com.capella.domain.enums.SubComposition;
import com.capella.domain.model.composition.CompositionModel;
import com.capella.domain.model.compositioncomponent.CompositionComponentModel;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = DomainConstant.COMPOSITION_DETAIL_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.COMPOSITION_DETAIL_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.COMPOSITION_DETAIL_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class CompositionDetailModel extends CodeBasedModel {

    public static final String COMPOSITION_DETAIL_RELATION = "composition_detail_id";

    @Enumerated(EnumType.STRING)
    private SubComposition subComposition;
    @Enumerated(EnumType.STRING)
    private CompositionUseType useType;
    private int sequenceNumber;
    private BigDecimal percentage;
    private String longText;
    private String shortText;
    private String searchText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="compositions_composition_details",
            joinColumns = @JoinColumn(name = COMPOSITION_DETAIL_RELATION), inverseJoinColumns = @JoinColumn(name = CompositionModel.COMPOSITION_RELATION))
    private CompositionModel composition;

    @ManyToOne(fetch = FetchType.LAZY)
    private CompositionComponentModel compositionComponent;

}
