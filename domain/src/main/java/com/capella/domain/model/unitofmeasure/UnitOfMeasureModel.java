package com.capella.domain.model.unitofmeasure;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.UnitOfMeasureType;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.UNIT_OF_MEASURE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.UNIT_OF_MEASURE_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.UNIT_OF_MEASURE_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class UnitOfMeasureModel extends CodeBasedModel {

    private String longText;

    private String shortText;

    private String searchText;

    @Enumerated(EnumType.STRING)
    private UnitOfMeasureType unitOfMeasureType;

}
