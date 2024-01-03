package com.capella.controller.v1.manufacturer;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.manufacturer.ManufacturerData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.manufacturer.ManufacturerFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("manufacturerControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.MANUFACTURER)
@RequiredArgsConstructor
@Slf4j
public class ManufacturerController {
    protected final ManufacturerFacade manufacturerFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody ManufacturerData manufacturerData){
        log.info("Inside save of ManufacturerController",manufacturerData);
        manufacturerFacade.save(manufacturerData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of ManufacturerController",code);
        var userGenericGroupData = manufacturerFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(userGenericGroupData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of ManufacturerController");
        var userGenericGroupDatas = manufacturerFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(userGenericGroupDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of ManufacturerController",code);
        manufacturerFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
