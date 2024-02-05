package com.capella.domain.data.menu;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.permission.PermissionData;
import com.capella.domain.data.userrole.UserRoleData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"parent","items"})
    private MenuData parent;
    @JsonIgnoreProperties({"parent"})
    private List<MenuData> items;
    private List<PermissionData> permissions;
    private List<UserRoleData> userRoles;
}
