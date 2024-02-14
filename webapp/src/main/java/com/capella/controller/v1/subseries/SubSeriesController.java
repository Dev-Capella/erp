package com.capella.controller.v1.subseries;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.subseries.SubSeriesData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.subseries.SubSeriesFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("subSeriesControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.SUBSERIES)
@RequiredArgsConstructor
@Slf4j
public class SubSeriesController {

    protected final SubSeriesFacade subSeriesFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody SubSeriesData subSeriesData){
        log.info("Inside save of SubSeriesController",subSeriesData);
        subSeriesFacade.save(subSeriesData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of SubSeriesController",code);
        subSeriesFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of SubSeriesController",code);
        var subSeriesData = subSeriesFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(subSeriesData);
        return response;
    }
}
