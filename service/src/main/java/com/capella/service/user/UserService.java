package com.capella.service.user;

import com.capella.domain.model.user.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserModel getUserModel(String username);
}
