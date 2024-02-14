package com.capella.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoundingCriteriaType {
    RAISE,
    ROUND,
    TRUNCATE
}
