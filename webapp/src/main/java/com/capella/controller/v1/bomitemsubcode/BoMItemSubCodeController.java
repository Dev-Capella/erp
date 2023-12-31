package com.capella.controller.v1.bomitemsubcode;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.bomitemsubcode.BoMItemSubCodeData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.bomitemsubcode.BoMItemSubCodeFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("bomSubCodeControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.BOMITEMSUBCODE)
@RequiredArgsConstructor
@Slf4j
public class BoMItemSubCodeController {
    protected final BoMItemSubCodeFacade bomItemSubCodeFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody BoMItemSubCodeData bomItemSubCodeData){
        log.info("Inside save of BoMItemSubCodeController",bomItemSubCodeData);
        bomItemSubCodeFacade.save(bomItemSubCodeData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of BoMItemSubCodeController",code);
        bomItemSubCodeFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of BoMItemSubCodeController",code);
        var bomItemSubCodeData = bomItemSubCodeFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(bomItemSubCodeData);
        return response;
    }
}
