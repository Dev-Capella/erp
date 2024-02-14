package com.capella.controller.v1.countertype;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.countertype.CounterTypeData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.countertype.CounterTypeFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("counterTypeControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.COUNTERTYPE)
@RequiredArgsConstructor
@Slf4j
public class CounterTypeController {
    protected final CounterTypeFacade counterTypeFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody CounterTypeData counterTypeData){
        log.info("Inside save of CounterTypeController",counterTypeData);
        counterTypeFacade.save(counterTypeData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of CounterTypeController",code);
        var counterTypeData = counterTypeFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(counterTypeData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of CounterTypeController");
        var counterTypeDatas = counterTypeFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(counterTypeDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of CounterTypeController",code);
        counterTypeFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
