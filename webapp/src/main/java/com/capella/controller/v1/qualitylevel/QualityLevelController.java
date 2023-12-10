package com.capella.controller.v1.qualitylevel;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.qualitylevel.QualityLevelData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.qualitylevel.QualityLevelFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("qualityLevelControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.QUALITYLEVEL)
@RequiredArgsConstructor
@Slf4j
public class QualityLevelController {

    protected final QualityLevelFacade qualityLevelFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody QualityLevelData qualityLevelData){
        log.info("Inside save of QualityLevelController",qualityLevelData);
        qualityLevelFacade.save(qualityLevelData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of QualityLevelController",code);
        qualityLevelFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of QualityLevelController",code);
        var qualityLevelData = qualityLevelFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(qualityLevelData);
        return response;
    }

}
