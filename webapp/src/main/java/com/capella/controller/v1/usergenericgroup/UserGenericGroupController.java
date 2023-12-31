package com.capella.controller.v1.usergenericgroup;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.unitofmeasure.UnitOfMeasureData;
import com.capella.domain.data.usergenericgroup.UserGenericGroupData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.unitofmeasure.UnitOfMeasureFacade;
import com.capella.facade.usergenericgroup.UserGenericGroupFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("userGenericGroupControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.USERGENERICGROUP)
@RequiredArgsConstructor
@Slf4j
public class UserGenericGroupController {
    protected final UserGenericGroupFacade userGenericGroupFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody UserGenericGroupData userGenericGroupData){
        log.info("Inside save of UserGenericGroupController",userGenericGroupData);
        userGenericGroupFacade.save(userGenericGroupData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of UserGenericGroupController",code);
        var userGenericGroupData = userGenericGroupFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(userGenericGroupData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of UserGenericGroupController");
        var userGenericGroupDatas = userGenericGroupFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(userGenericGroupDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of UserGenericGroupController",code);
        userGenericGroupFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
