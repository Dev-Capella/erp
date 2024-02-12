package com.capella.controller.v1.washsymbolcategory;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.washsymbolcategory.WashSymbolCategoryData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.washsymbolcategory.WashSymbolCategoryFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("washSymbolCategoryControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.WASHSYMBOLCATEGORY)
@RequiredArgsConstructor
@Slf4j
public class WashSymbolCategoryController {
    protected final WashSymbolCategoryFacade washSymbolCategoryFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody WashSymbolCategoryData washSymbolCategoryData){
        log.info("Inside save of WashSymbolCategoryController",washSymbolCategoryData);
        washSymbolCategoryFacade.save(washSymbolCategoryData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of WashSymbolCategoryController",code);
        var washSymbolCategoryData = washSymbolCategoryFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(washSymbolCategoryData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of WashSymbolCategoryController");
        var washSymbolCategoryDatas = washSymbolCategoryFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(washSymbolCategoryDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of WashSymbolCategoryController",code);
        washSymbolCategoryFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
