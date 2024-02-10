package com.capella.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CheckType {
    ALPHA_NUMERIC,
    ALPHABETIC,
    NUMERIC,
    ANYTHING,
    NONE
}
