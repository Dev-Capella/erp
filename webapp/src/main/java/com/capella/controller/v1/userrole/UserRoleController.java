package com.capella.controller.v1.userrole;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.userrole.UserRoleData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.userrole.UserRoleFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("userRoleControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.USERROLE)
@RequiredArgsConstructor
@Slf4j
public class UserRoleController {

    protected final UserRoleFacade userRoleFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody UserRoleData userRoleData){
        log.info("Inside save of UserRoleController",userRoleData);
        userRoleFacade.save(userRoleData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of UserRoleController",code);
        var userGenericGroupData = userRoleFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(userGenericGroupData);
        return response;
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('item_type_read')")
    public ServiceResponseData getAll(){
        log.info("Inside getAll of UserRoleController");
        var userRoleDatas = userRoleFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(userRoleDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of UserRoleController",code);
        userRoleFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
