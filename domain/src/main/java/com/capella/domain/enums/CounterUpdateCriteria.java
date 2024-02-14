package com.capella.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CounterUpdateCriteria {
    NA,
    ALWAYS,
    YES_IF_IT_IS_THE_NEXT_VALUE,
    NEVER
}
