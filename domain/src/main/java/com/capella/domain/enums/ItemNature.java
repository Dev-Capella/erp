package com.capella.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemNature {
    PRODUCT,
    NONSTOCKPRODUCT,
    TOOL,
    CONTAINER,
    SERVICES,
    CHARGERS,
    RECIPE,
    DESIGN,
    PATTERN,
    COST_ELEMENT
}
