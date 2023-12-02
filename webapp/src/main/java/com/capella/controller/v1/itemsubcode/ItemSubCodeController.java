package com.capella.controller.v1.itemsubcode;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.itemsubcode.ItemSubCodeFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("itemSubCodeControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.ITEMSUBCODE)
@RequiredArgsConstructor
@Slf4j
public class ItemSubCodeController {

    protected final ItemSubCodeFacade itemSubCodeFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody ItemSubCodeData itemSubCodeData){
        log.info("Inside save of ItemSubCodeController",itemSubCodeData);
        itemSubCodeFacade.save(itemSubCodeData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of ItemSubCodeController",code);
        itemSubCodeFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
