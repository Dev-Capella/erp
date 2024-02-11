package com.capella.domain.model.menu;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.permission.PermissionModel;
import com.capella.domain.model.userrole.UserRoleModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = DomainConstant.MENU_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.MENU_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.MENU_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class MenuModel extends CodeBasedModel {
    public static final String MENU_RELATION = "menu_id";

    private String longText;
    private String shortText;
    private String searchText;
    private String routerLink;
    private int queue;
    private String icon;
    private boolean root;

    @ManyToOne(fetch = FetchType.LAZY)
    private MenuModel parent;

    @OneToMany(mappedBy = "parent")
    @OrderBy(value="queue")
    private Set<MenuModel> items;

    @ManyToMany
    @JoinTable(name ="menus_permissions",
            joinColumns = @JoinColumn(name = MENU_RELATION), inverseJoinColumns = @JoinColumn(name = PermissionModel.PERMISSION_RELATION))
    private Set<PermissionModel> permissions;

    @ManyToMany
    @JoinTable(name ="menus_user_roles",
            joinColumns = @JoinColumn(name = MENU_RELATION), inverseJoinColumns = @JoinColumn(name = UserRoleModel.USER_ROLE_RELATION))
    private Set<UserRoleModel> userRoles;


}
