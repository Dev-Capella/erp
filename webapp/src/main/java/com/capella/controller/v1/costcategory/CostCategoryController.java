package com.capella.controller.v1.costcategory;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.costcategory.CostCategoryData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.costcategory.CostCategoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController("costCategoryControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.COSTCATEGORY)
@RequiredArgsConstructor
@Slf4j
public class CostCategoryController {
    protected final CostCategoryFacade costCategoryFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody CostCategoryData costCategoryData){
        log.info("Inside save of CostCategoryController",costCategoryData);
        costCategoryFacade.save(costCategoryData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of CostCategoryController",code);
        var costCategoryData = costCategoryFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(costCategoryData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of CostCategoryController");
        var costCategoryDatas = costCategoryFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(costCategoryDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of CostCategoryController",code);
        costCategoryFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
