package com.capella.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SearchOperator {
    AND("AND"),
    OR("ORD");

    private String value;
}
