package com.capella.domain.model.parameter;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.ParameterDataType;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.PARAMETER_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.PARAMETER_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.PARAMETER_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class ParameterModel extends CodeBasedModel {

    @Enumerated(EnumType.STRING)
    private ParameterDataType dataType;

    @NotEmpty(message = "{validation.parameterModel.value.notEmpty}")
    private String value;

    private String longText;

    private String shortText;

    private String searchText;
}
