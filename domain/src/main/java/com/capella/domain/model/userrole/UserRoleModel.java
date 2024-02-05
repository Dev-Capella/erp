package com.capella.domain.model.userrole;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.menu.MenuModel;
import com.capella.domain.model.permission.PermissionModel;
import com.capella.domain.model.user.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = DomainConstant.USERROLE_TABLE_NAME)
@Getter
@Setter
public class UserRoleModel extends CodeBasedModel {

    public static final String USER_ROLE_RELATION = "user_role_id";

    private String longText;
    private String shortText;
    private String searchText;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="user_roles_permissions",
            joinColumns = @JoinColumn(name = USER_ROLE_RELATION), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<PermissionModel> permissions;

    @ManyToMany
    @JoinTable(name ="users_user_roles",
            joinColumns = @JoinColumn(name = USER_ROLE_RELATION), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserModel> users;

    @ManyToMany
    @JoinTable(name ="menus_user_roles",
            joinColumns = @JoinColumn(name = USER_ROLE_RELATION), inverseJoinColumns = @JoinColumn(name = MenuModel.MENU_RELATION))
    private Set<MenuModel> menus;

}
