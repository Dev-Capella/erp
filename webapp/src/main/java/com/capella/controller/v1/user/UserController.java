package com.capella.controller.v1.user;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.user.UserData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.user.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(ControllerMappings.USERNAME)
    public ServiceResponseData get(@PathVariable String username){
        log.info("Inside get of UserController",username);
        var userData = userFacade.get(username);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(userData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of UserController");
        var userDatas = userFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(userDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.USERNAME)
    public ServiceResponseData delete(@PathVariable String username){
        log.info("Inside delete of UserController",username);
        userFacade.delete(username);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
