package com.capella.controller.v1.businesspartner;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.businesspartner.BusinessPartnerData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.businesspartner.BusinessPartnerFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("businessPartnerControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.BUSINESSPARTNER)
@RequiredArgsConstructor
@Slf4j
public class BusinessPartnerController {

    protected final BusinessPartnerFacade businessPartnerFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody BusinessPartnerData businessPartnerData){
        log.info("Inside save of BusinessPartnerController",businessPartnerData);
        businessPartnerFacade.save(businessPartnerData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of BusinessPartnerController",code);
        var businessPartnerData = businessPartnerFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(businessPartnerData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of BusinessPartnerController");
        var businessPartnerDatas = businessPartnerFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(businessPartnerDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of BusinessPartnerController",code);
        businessPartnerFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
