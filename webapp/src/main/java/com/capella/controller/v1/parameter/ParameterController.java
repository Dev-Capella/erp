package com.capella.controller.v1.parameter;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.parameter.ParameterData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.parameter.ParameterFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("parameterControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.PARAMETER)
@RequiredArgsConstructor
@Slf4j
public class ParameterController {
    protected final ParameterFacade parameterFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody ParameterData parameterData){
        log.info("Inside save of ParameterController",parameterData);
        parameterFacade.save(parameterData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of ParameterController",code);
        var parameterData = parameterFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(parameterData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of ParameterController");
        var parameterDatas = parameterFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(parameterDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of ParameterController",code);
        parameterFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
