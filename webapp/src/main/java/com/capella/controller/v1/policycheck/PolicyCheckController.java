package com.capella.controller.v1.policycheck;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.policycheck.PolicyCheckData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.policycheck.PolicyCheckFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("policyCheckControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.POLICYCHECK)
@RequiredArgsConstructor
@Slf4j
public class PolicyCheckController {

    protected final PolicyCheckFacade policyCheckFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody PolicyCheckData policyCheckData){
        log.info("Inside save of PolicyCheckController",policyCheckData);
        policyCheckFacade.save(policyCheckData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of PolicyCheckController",code);
        var policyCheckData = policyCheckFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(policyCheckData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of PolicyCheckController");
        var policyCheckDatas = policyCheckFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(policyCheckDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of PolicyCheckController",code);
        policyCheckFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
