package com.capella.domain.data.userrole;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.permission.PermissionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UserRoleData extends BaseDescriptionData {
    private Set<PermissionData> permissions;
}
