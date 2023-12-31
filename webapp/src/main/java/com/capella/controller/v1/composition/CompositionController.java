package com.capella.controller.v1.composition;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.composition.CompositionData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.composition.CompositionFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("compositionControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.COMPOSITION)
@RequiredArgsConstructor
@Slf4j
public class CompositionController {

    protected final CompositionFacade compositionFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody CompositionData compositionData){
        log.info("Inside save of CompositionController",compositionData);
        compositionFacade.save(compositionData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of CompositionController",code);
        var compositionData = compositionFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(compositionData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of CompositionController");
        var compositionDatas = compositionFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(compositionDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of CompositionController",code);
        compositionFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE + ControllerMappings.COMPOSITIONDETAIL)
    public ServiceResponseData getCompositionDetailsByComposition(@PathVariable String code){
        log.info("Inside getCompositionDetailsByComposition of CompositionController",code);
        var compositionDetailData = compositionFacade.getCompositionDetailsByComposition(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(compositionDetailData);
        return response;
    }
}
