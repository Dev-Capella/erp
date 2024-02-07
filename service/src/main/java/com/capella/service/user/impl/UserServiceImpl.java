package com.capella.service.user.impl;
import com.capella.base.util.ErpWebUtils;
import com.capella.domain.data.login.LoginRequestData;
import com.capella.domain.model.user.UserModel;
import com.capella.persistence.dao.user.UserDao;
import com.capella.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.*;

@Service
@Qualifier("erpUserService")
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private static final String LOGIN_REQUEST = "loginRequest";
    private final UserDao userDao;
    @Override
    public UserModel getUserModel(String username) {
        var userModel = userDao.getByUsername(username);
        return userModel;
    }

    @Override
    public Set<UserModel> getUserModels() {
        List<UserModel> userModels = userDao.findAll();
        Set<UserModel> userModelSet = new HashSet<>(userModels);
        return userModelSet;
    }

    @Override
    public UserModel getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var username = String.valueOf(authentication.getPrincipal());
        return this.getUserModel(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var currentRequest = ErpWebUtils.getCurrentHttpRequest();
        var loginRequest = (LoginRequestData) currentRequest.getAttribute(LOGIN_REQUEST);
        username = username.toLowerCase(Locale.ENGLISH);
        var user = userDao.getByUsername(username);

        if(user == null){
            log.error("User: [{}] is not found.", username);
            throw new UsernameNotFoundException(username);
        }else{
            log.info("User: [{}] found in the database.", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getUserRoles().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getCode())));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
