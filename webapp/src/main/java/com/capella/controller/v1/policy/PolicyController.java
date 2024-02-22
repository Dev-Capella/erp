package com.capella.controller.v1.policy;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.policy.PolicyFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("policyControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.POLICY)
@RequiredArgsConstructor
@Slf4j
public class PolicyController {

    protected final PolicyFacade policyFacade;

    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of PolicyController");
        var policyDatas = policyFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(policyDatas);
        return response;
    }
}
