package com.capella.facade.user.impl;

import com.capella.domain.data.user.UserData;
import com.capella.domain.model.user.UserModel;
import com.capella.domain.model.userrole.UserRoleModel;
import com.capella.facade.user.UserFacade;
import com.capella.service.model.ModelService;
import com.capella.service.user.UserService;
import com.capella.service.userrole.UserRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
@Slf4j
public class UserFacadeImpl implements UserFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final UserService userService;
    protected final UserRoleService userRoleService;
    protected final PasswordEncoder passwordEncoder;

    @Override
    public void save(UserData userData) {
        UserModel userModel;
        if(userData.isNew()){
            userModel = modelMapper.map(userData, UserModel.class);
        }else{
            userModel = userService.getUserModel(userData.getUsername());
            modelMapper.map(userData, userModel);
        }

        if(StringUtils.isNotEmpty(userData.getDefinedPassword())){
            userModel.setPassword(passwordEncoder.encode(userData.getDefinedPassword()));
        }

        Set<UserRoleModel> userRoles = new HashSet<>();
        if(CollectionUtils.isNotEmpty(userData.getUserRoles())){
            userData.getUserRoles().forEach(userRole ->
                    userRoles.add(userRoleService.getUserRoleModel(userRole.getCode())));
        }
        userModel.setUserRoles(userRoles);
        modelService.save(userModel);
    }

    @Override
    public Set<UserData> getAll() {
        var userModels = userService.getUserModels();
        return Set.of(modelMapper.map(userModels, UserData[].class));
    }

    @Override
    public UserData get(String username) {
        var userModel = userService.getUserModel(username);
        return modelMapper.map(userModel,UserData.class);
    }

    @Override
    public void delete(String username) {
        var userModel = userService.getUserModel(username);
        modelService.remove(userModel);
    }
}
