package com.capella.service.user;

import com.capella.domain.model.user.UserModel;

public interface UserService {
    UserModel getUserModel(String username);
}
