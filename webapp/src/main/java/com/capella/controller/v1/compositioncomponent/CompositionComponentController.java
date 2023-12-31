package com.capella.controller.v1.compositioncomponent;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.compositioncomponent.CompositionComponentData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.compositioncomponent.CompositionComponentFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("compositionComponentControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.COMPOSITIONCOMPONENT)
@RequiredArgsConstructor
@Slf4j
public class CompositionComponentController {

    protected final CompositionComponentFacade compositionComponentFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody CompositionComponentData compositionComponentData){
        log.info("Inside save of CompositionComponentController",compositionComponentData);
        compositionComponentFacade.save(compositionComponentData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of CompositionComponentController",code);
        var compositionComponentData = compositionComponentFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(compositionComponentData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of CompositionComponentController");
        var compositionComponentDatas = compositionComponentFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(compositionComponentDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of CompositionComponentController",code);
        compositionComponentFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
