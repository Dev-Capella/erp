package com.capella.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemNature {
    PRODUCT,
    NON_STOCK_PRODUCT,
    TOOL,
    CONTAINER,
    SERVICES,
    CHARGERS,
    RECIPE,
    DESIGN,
    PATTERN,
    COST_ELEMENT
}
