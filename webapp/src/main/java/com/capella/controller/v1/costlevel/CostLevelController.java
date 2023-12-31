package com.capella.controller.v1.costlevel;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.costlevel.CostLevelData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.costlevel.CostLevelFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController("costLevelControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.COSTLEVEL)
@RequiredArgsConstructor
@Slf4j
public class CostLevelController {
    protected final CostLevelFacade costLevelFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody CostLevelData costLevelData){
        log.info("Inside save of CostLevelController",costLevelData);
        costLevelFacade.save(costLevelData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of CostLevelController",code);
        var costLevelData = costLevelFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(costLevelData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of CostLevelController");
        var costLevelDatas = costLevelFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(costLevelDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of CostLevelController",code);
        costLevelFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
