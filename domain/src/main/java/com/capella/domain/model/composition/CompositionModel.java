package com.capella.domain.model.composition;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.compositiondetail.CompositionDetailModel;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = DomainConstant.COMPOSITION_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.COMPOSITION_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.COMPOSITION_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class CompositionModel extends CodeBasedModel {
    public static final String COMPOSITION_RELATION = "composition_id";
    private String longText;
    private String shortText;
    private String searchText;
    private Boolean valid;

    @OneToMany
    @JoinTable(name="compositions_composition_details",
            joinColumns = @JoinColumn(name = COMPOSITION_RELATION), inverseJoinColumns = @JoinColumn(name = CompositionDetailModel.COMPOSITION_DETAIL_RELATION))
    private Set<CompositionDetailModel> compositionDetails;

}
