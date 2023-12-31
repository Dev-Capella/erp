package com.capella.controller.v1.routingitemsubcode;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.routingitemsubcode.RoutingItemSubCodeData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.itemsubcode.ItemSubCodeFacade;
import com.capella.facade.routingitemsubcode.RoutingItemSubCodeFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("routingSubCodeControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.ROUTINGITEMSUBCODE)
@RequiredArgsConstructor
@Slf4j
public class RoutingItemSubCodeController {
    protected final RoutingItemSubCodeFacade routingItemSubCodeFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody RoutingItemSubCodeData routingItemSubCodeData){
        log.info("Inside save of RoutingItemSubCodeController",routingItemSubCodeData);
        routingItemSubCodeFacade.save(routingItemSubCodeData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of RoutingItemSubCodeController",code);
        routingItemSubCodeFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of RoutingItemSubCodeController",code);
        var routingItemSubCodeData = routingItemSubCodeFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(routingItemSubCodeData);
        return response;
    }
}
