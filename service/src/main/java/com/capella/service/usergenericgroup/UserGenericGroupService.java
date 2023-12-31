package com.capella.service.usergenericgroup;

import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;

import java.util.Set;

public interface UserGenericGroupService {
    UserGenericGroupModel getUserGenericGroupModel(String code);
    Set<UserGenericGroupModel> getUserGenericGroupModels();
}
