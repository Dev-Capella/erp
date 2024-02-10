package com.capella.controller.v1.model;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.domainmodel.DomainModelFacade;
import com.capella.facade.manufacturer.ManufacturerFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("domainModelControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.DOMAINMODEL)
@RequiredArgsConstructor
@Slf4j
public class DomainModelController {
    protected final DomainModelFacade domainModelFacade;

    @GetMapping
    public ServiceResponseData getAllDomainModels(){
        log.info("Inside getAllDomainModels of DomainModelController");
        var domainModelDatas = domainModelFacade.getAllDomainModels();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(domainModelDatas);
        return response;
    }
}
