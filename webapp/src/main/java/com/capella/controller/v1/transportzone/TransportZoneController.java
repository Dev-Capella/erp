package com.capella.controller.v1.transportzone;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.transportzone.TransportZoneData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.transportzone.TransportZoneFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("transportZoneControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.TRANSPORTZONE)
@RequiredArgsConstructor
@Slf4j
public class TransportZoneController {

    protected final TransportZoneFacade transportZoneFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody TransportZoneData transportZoneData){
        log.info("Inside save of TransportZoneController",transportZoneData);
        transportZoneFacade.save(transportZoneData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of TransportZoneController",code);
        var transportZoneData = transportZoneFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(transportZoneData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of TransportZoneController");
        var transportZoneDatas = transportZoneFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(transportZoneDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of TransportZoneController",code);
        transportZoneFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
