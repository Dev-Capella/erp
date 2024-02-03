package com.capella.domain.data.user;

import com.capella.domain.data.base.BaseData;
import com.capella.domain.data.userrole.UserRoleData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UserData extends BaseData {

    @EqualsAndHashCode.Include
    private String username;
    private String firstName;
    private String lastName;
    private String definedPassword;
    private String email;
    private String phoneNumber;
    private Set<UserRoleData> userRoles;
}
