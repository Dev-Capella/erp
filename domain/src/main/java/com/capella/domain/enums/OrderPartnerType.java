package com.capella.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderPartnerType {
    CUSTOMER,
    SUPPLIER,
    INTERNAL
}
