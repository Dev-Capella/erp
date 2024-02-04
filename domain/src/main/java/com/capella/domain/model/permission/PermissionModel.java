package com.capella.domain.model.permission;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.menu.MenuModel;
import com.capella.domain.model.userrole.UserRoleModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = DomainConstant.PERMISSION_TABLE_NAME)
@Getter
@Setter
public class PermissionModel extends CodeBasedModel {
    public static final String PERMISSION_RELATION = "permission_id";
    private String longText;
    private String shortText;
    private String searchText;

    @ManyToMany
    @JoinTable(name ="user_roles_permissions",
            joinColumns = @JoinColumn(name = PERMISSION_RELATION), inverseJoinColumns = @JoinColumn(name = "user_role_id"))
    private Set<UserRoleModel> userRoles;

    @ManyToMany
    @JoinTable(name ="menus_permissions",
            joinColumns = @JoinColumn(name = PERMISSION_RELATION), inverseJoinColumns = @JoinColumn(name = MenuModel.MENU_RELATION))
    private Set<MenuModel> menus;

}
