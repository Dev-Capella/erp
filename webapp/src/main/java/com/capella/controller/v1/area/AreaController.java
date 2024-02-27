package com.capella.controller.v1.area;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.area.AreaData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.area.AreaFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("areaControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.AREA)
@RequiredArgsConstructor
@Slf4j
public class AreaController {

    protected final AreaFacade areaFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody AreaData areaData){
        log.info("Inside save of AreaController",areaData);
        areaFacade.save(areaData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of AreaController",code);
        var areaData = areaFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(areaData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of AreaController");
        var areaDatas = areaFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(areaDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of AreaController",code);
        areaFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
