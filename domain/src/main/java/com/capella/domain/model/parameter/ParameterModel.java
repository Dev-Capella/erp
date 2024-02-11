package com.capella.domain.model.parameter;

import com.capella.domain.enums.ParameterDataType;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Parameter")
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
