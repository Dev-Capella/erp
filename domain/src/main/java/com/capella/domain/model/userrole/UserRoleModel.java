package com.capella.domain.model.userrole;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.permission.PermissionModel;
import com.capella.domain.model.user.UserModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Entity
@Table(name = DomainConstant.USERROLE_TABLE_NAME)
@Getter
public class UserRoleModel extends CodeBasedModel {

    public static final String USER_ROLE_RELATION = "user_role_id";

    private String longText;
    private String shortText;
    private String searchText;

    @ManyToMany
    @JoinTable(name ="user_roles_permissions",
            joinColumns = @JoinColumn(name = USER_ROLE_RELATION), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<PermissionModel> permissions;

    @ManyToMany
    @JoinTable(name ="users_user_roles",
            joinColumns = @JoinColumn(name = USER_ROLE_RELATION), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserModel> users;

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public void setUsers(Set<UserModel> users) {
        this.users = users;
    }
    public void setPermissions(Set<PermissionModel> permissions) {
        this.permissions = permissions;
    }
}
