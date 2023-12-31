package com.capella.domain.data.user;

import com.capella.domain.data.base.BaseData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UserData extends BaseData {

    @EqualsAndHashCode.Include
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
}
