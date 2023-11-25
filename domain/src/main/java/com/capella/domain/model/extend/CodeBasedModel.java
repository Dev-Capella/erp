package com.capella.domain.model.extend;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Getter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@MappedSuperclass
@FieldNameConstants
public abstract class CodeBasedModel extends ItemModel {

    @NotEmpty(message = "{validation.codeBasedItemModel.code.notEmpty}")
    @Size(min = 1, message = "{validation.codeBasedItemModel.code.minChar}")
    @EqualsAndHashCode.Include
    private String code;

    public void setCode(String code) {
        this.code = code;
    }
}
