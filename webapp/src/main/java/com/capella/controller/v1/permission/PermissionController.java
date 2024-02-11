package com.capella.controller.v1.permission;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.permission.PermissionData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.permission.PermissionFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController("permissionControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.PERMISSION)
@RequiredArgsConstructor
@Slf4j
public class PermissionController {
    protected final PermissionFacade permissionFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody PermissionData permissionData){
        log.info("Inside save of PermissionController",permissionData);
        permissionFacade.save(permissionData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of PermissionController",code);
        var permissionData = permissionFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(permissionData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of PermissionController");
        var permissionDatas = permissionFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(permissionDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of PermissionController",code);
        permissionFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
