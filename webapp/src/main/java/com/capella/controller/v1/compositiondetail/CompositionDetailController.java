package com.capella.controller.v1.compositiondetail;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.compositiondetail.CompositionDetailData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.compositiondetail.CompositionDetailFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("compositionDetailControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.COMPOSITIONDETAIL)
@RequiredArgsConstructor
@Slf4j
public class CompositionDetailController {

    protected final CompositionDetailFacade compositionDetailFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody CompositionDetailData compositionDetailData){
        log.info("Inside save of CompositionDetailController",compositionDetailData);
        compositionDetailFacade.save(compositionDetailData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of CompositionDetailController",code);
        compositionDetailFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of CompositionDetailController",code);
        var compositionDetailData = compositionDetailFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(compositionDetailData);
        return response;
    }
}
