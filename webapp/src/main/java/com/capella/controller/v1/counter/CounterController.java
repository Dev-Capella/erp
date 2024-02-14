package com.capella.controller.v1.counter;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.counter.CounterData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.counter.CounterFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("counterControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.COUNTER)
@RequiredArgsConstructor
@Slf4j
public class CounterController {
    protected final CounterFacade counterFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody CounterData counterData){
        log.info("Inside save of CounterController",counterData);
        counterFacade.save(counterData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of CounterController",code);
        var counterData = counterFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(counterData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of CounterController");
        var counterDatas = counterFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(counterDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of CounterController",code);
        counterFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
