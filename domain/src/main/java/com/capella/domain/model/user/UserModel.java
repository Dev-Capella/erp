package com.capella.domain.model.user;

import com.capella.domain.model.extend.ItemModel;
import com.capella.domain.model.userrole.UserRoleModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "User")
@Getter
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="users_user_roles",
            joinColumns = @JoinColumn(name = USER_RELATION), inverseJoinColumns = @JoinColumn(name = "user_role_id"))
    private Set<UserRoleModel> userRoles;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void setUserRoles(Set<UserRoleModel> userRoles) {
        this.userRoles = userRoles;
    }
}
