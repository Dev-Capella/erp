package com.capella.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusAllowed {
    NA,
    ACTIVE,
    SUSPENDED_ACTIVE,
    SUSPENDED_APPROWED_ACTIVE
}
