package com.capella.domain.data.parameter;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.enums.ParameterDataType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ParameterData extends BaseDescriptionData {
    private String value;
    private ParameterDataType dataType;
}
