package com.capella.controller.v1.unitofmeasure;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.unitofmeasure.UnitOfMeasureData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.unitofmeasure.UnitOfMeasureFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("unitOfMeasureControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.UNITOFMEASURE)
@RequiredArgsConstructor
@Slf4j
public class UnitOfMeasureController {

    protected final UnitOfMeasureFacade unitOfMeasureFacade;

    @PostMapping(ControllerMappings.UNITOFMEASURE)
    public ServiceResponseData save(@Validated @RequestBody UnitOfMeasureData unitOfMeasureData){
        log.info("Inside save of UnitOfMeasureController",unitOfMeasureData);
        unitOfMeasureFacade.save(unitOfMeasureData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
