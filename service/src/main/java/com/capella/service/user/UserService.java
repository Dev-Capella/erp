package com.capella.service.user;

import com.capella.domain.model.user.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface UserService extends UserDetailsService {
    UserModel getUserModel(String username);
    Set<UserModel> getUserModels();
}
