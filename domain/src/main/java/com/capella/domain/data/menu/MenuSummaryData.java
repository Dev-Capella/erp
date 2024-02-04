package com.capella.domain.data.menu;

import com.capella.domain.data.base.BaseDescriptionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class MenuSummaryData extends BaseDescriptionData {
    private String routerLink;
    private int queue;
    private String icon;
    private boolean root;
}
