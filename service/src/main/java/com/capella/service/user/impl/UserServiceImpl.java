package com.capella.service.user.impl;
import com.capella.domain.model.user.UserModel;
import com.capella.persistence.dao.user.UserDao;
import com.capella.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    @Override
    public UserModel getUserModel(String username) {
        var userModel = userDao.getByUsername(username);
        return userModel;
    }
}
