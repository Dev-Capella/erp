package com.capella.controller.v1.itemsubcodechecktype;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.itemsubcodechecktype.ItemSubCodeCheckTypeData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.itemsubcodechecktype.ItemSubCodeCheckTypeFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("itemSubCodeCheckTypeControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.ITEMSUBCODECHECKTYPE)
@RequiredArgsConstructor
@Slf4j
public class ItemSubCodeCheckTypeController {
    protected final ItemSubCodeCheckTypeFacade itemSubCodeCheckTypeFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody ItemSubCodeCheckTypeData itemSubCodeCheckTypeData){
        log.info("Inside save of ItemSubCodeCheckTypeController",itemSubCodeCheckTypeData);
        itemSubCodeCheckTypeFacade.save(itemSubCodeCheckTypeData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of ItemSubCodeCheckTypeController",code);
        var itemSubCodeCheckTypeData = itemSubCodeCheckTypeFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(itemSubCodeCheckTypeData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of ItemSubCodeCheckTypeController");
        var itemSubCodeCheckTypeDatas = itemSubCodeCheckTypeFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(itemSubCodeCheckTypeDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of ItemSubCodeCheckTypeController",code);
        itemSubCodeCheckTypeFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE + "/policy")
    public ServiceResponseData getAllItemSubCodeCheckTypeByPolicy(@PathVariable String code){
        log.info("Inside getAll of ItemSubCodeCheckTypeController");
        var itemSubCodeCheckTypeDatas = itemSubCodeCheckTypeFacade.getItemSubCodeCheckTypeByPolicyFacade(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(itemSubCodeCheckTypeDatas);
        return response;
    }
}
