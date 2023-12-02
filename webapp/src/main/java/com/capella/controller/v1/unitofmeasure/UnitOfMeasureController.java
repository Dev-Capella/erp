package com.capella.controller.v1.unitofmeasure;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.unitofmeasure.UnitOfMeasureData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.unitofmeasure.UnitOfMeasureFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("unitOfMeasureControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.UNITOFMEASURE)
@RequiredArgsConstructor
@Slf4j
public class UnitOfMeasureController {

    protected final UnitOfMeasureFacade unitOfMeasureFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody UnitOfMeasureData unitOfMeasureData){
        log.info("Inside save of UnitOfMeasureController",unitOfMeasureData);
        unitOfMeasureFacade.save(unitOfMeasureData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of UnitOfMeasureController",code);
        var unitOfMeasureData = unitOfMeasureFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(unitOfMeasureData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of UnitOfMeasureController");
        var unitOfMeasureDatas = unitOfMeasureFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(unitOfMeasureDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of UnitOfMeasureController",code);
        unitOfMeasureFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
