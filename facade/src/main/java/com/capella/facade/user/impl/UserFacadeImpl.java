package com.capella.facade.user.impl;

import com.capella.domain.data.user.UserData;
import com.capella.domain.model.user.UserModel;
import com.capella.facade.user.UserFacade;
import com.capella.service.model.ModelService;
import com.capella.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
@Slf4j
public class UserFacadeImpl implements UserFacade {

    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final UserService userService;

    @Override
    public void save(UserData userData) {
        UserModel userModel;
        if(userData.isNew()){
            userModel = modelMapper.map(userData, UserModel.class);
        }else{
            userModel = userService.getUserModel(userData.getUsername());
            modelMapper.map(userData, userModel);
        }
        modelService.save(userModel);
    }
}
