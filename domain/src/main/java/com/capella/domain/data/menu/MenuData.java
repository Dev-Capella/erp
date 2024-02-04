package com.capella.domain.data.menu;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.permission.PermissionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class MenuData extends BaseDescriptionData {
    private String routerLink;
    private int queue;
    private String icon;
    private boolean root;
    private MenuData parent;
    private List<MenuData> items;
    private List<PermissionData> permissions;
}
