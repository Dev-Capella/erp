package com.capella.domain.model.user;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.extend.ItemModel;
import com.capella.domain.model.userrole.UserRoleModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = DomainConstant.USER_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.USER_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {"username"})},
        indexes = {@Index(name = DomainConstant.USER_TABLE_NAME + DomainConstant.USERNAME_IDX, columnList = "username")})
@Getter
@Setter
public class UserModel extends ItemModel {
    public static final String USER_RELATION = "user_id";
    @EqualsAndHashCode.Include
    private String username;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
    private Date lastLoginDate;

    @Transient
    private String definedPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="users_user_roles",
            joinColumns = @JoinColumn(name = USER_RELATION), inverseJoinColumns = @JoinColumn(name = UserRoleModel.USER_ROLE_RELATION))
    private Set<UserRoleModel> userRoles;

}
