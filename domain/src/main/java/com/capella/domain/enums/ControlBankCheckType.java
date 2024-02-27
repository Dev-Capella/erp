package com.capella.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ControlBankCheckType {
    MANDATORY,
    OPTIONAL,
    NO,
    USE_BIC_AS_BANK_CODE
}
