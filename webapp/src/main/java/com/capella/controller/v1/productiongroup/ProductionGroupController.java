package com.capella.controller.v1.productiongroup;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.productiongroup.ProductionGroupData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.productiongroup.ProductionGroupFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("productionGroupControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.PRODUCTIONGROUP)
@RequiredArgsConstructor
@Slf4j
public class ProductionGroupController {
    protected final ProductionGroupFacade productionGroupFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody ProductionGroupData productionGroupData){
        log.info("Inside save of ProductionGroupController",productionGroupData);
        productionGroupFacade.save(productionGroupData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of ProductionGroupController",code);
        var itemTypeData = productionGroupFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(itemTypeData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of ProductionGroupController");
        var itemTypeDatas = productionGroupFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(itemTypeDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of ProductionGroupController",code);
        productionGroupFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
