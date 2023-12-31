package com.capella.controller.v1.user;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.user.UserData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.user.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.USER)
@RequiredArgsConstructor
@Slf4j
public class UserController {

    protected final UserFacade userFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody UserData userData){
        log.info("Inside save of UserController",userData);
        userFacade.save(userData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
