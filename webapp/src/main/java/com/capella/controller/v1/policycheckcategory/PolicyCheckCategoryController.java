package com.capella.controller.v1.policycheckcategory;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.policycheckcategory.PolicyCheckCategoryData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.policycheckcategory.PolicyCheckCategoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("policyCheckCategoryControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.POLICYCHECKCATEGORY)
@RequiredArgsConstructor
@Slf4j
public class PolicyCheckCategoryController {

    protected final PolicyCheckCategoryFacade policyCheckCategoryFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody PolicyCheckCategoryData policyCheckCategoryData){
        log.info("Inside save of PolicyCheckCategoryController",policyCheckCategoryData);
        policyCheckCategoryFacade.save(policyCheckCategoryData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of PolicyCheckCategoryController",code);
        var policyCheckCategoryData = policyCheckCategoryFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(policyCheckCategoryData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of PolicyCheckCategoryController");
        var policyCheckCategoryDatas = policyCheckCategoryFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(policyCheckCategoryDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of PolicyCheckCategoryController",code);
        policyCheckCategoryFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
