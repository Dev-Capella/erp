package com.capella.controller.v1.washsymbol;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.washsymbol.WashSymbolData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.washsymbol.WashSymbolFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("washSymbolControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.WASHSYMBOL)
@RequiredArgsConstructor
@Slf4j
public class WashSymbolController {
    protected final WashSymbolFacade washSymbolFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody WashSymbolData washSymbolData){
        log.info("Inside save of WashSymbolController",washSymbolData);
        washSymbolFacade.save(washSymbolData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of WashSymbolController",code);
        var washSymbolData = washSymbolFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(washSymbolData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of WashSymbolController");
        var washSymbolDatas = washSymbolFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(washSymbolDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of WashSymbolController",code);
        washSymbolFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
