package com.capella.domain.data.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class BaseDescriptionData extends BaseData {
    private String longText;
    private String shortText;
    private String searchText;
}
