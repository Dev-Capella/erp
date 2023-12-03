package com.capella.controller.v1.itemtype;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.itemtype.ItemTypeFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("itemTypeControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.ITEMTYPE)
@RequiredArgsConstructor
@Slf4j
public class ItemTypeController {

    protected final ItemTypeFacade itemTypeFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody ItemTypeData itemTypeData){
        log.info("Inside save of ItemTypeController",itemTypeData);
        itemTypeFacade.save(itemTypeData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of ItemTypeController",code);
        var itemTypeData = itemTypeFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(itemTypeData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of ItemTypeController");
        var itemTypeDatas = itemTypeFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(itemTypeDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of ItemTypeController",code);
        itemTypeFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE + ControllerMappings.ITEMSUBCODE)
    public ServiceResponseData getItemSubCodesByItemType(@PathVariable String code){
        log.info("Inside getItemSubCodesByItemType of ItemTypeController",code);
        var itemTypeData = itemTypeFacade.getItemSubCodesByItemType(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(itemTypeData);
        return response;
    }

    @GetMapping(ControllerMappings.CODE + ControllerMappings.QUALITYLEVEL)
    public ServiceResponseData getQualityLevelsByItemType(@PathVariable String code){
        log.info("Inside getQualityLevelsByItemType of ItemTypeController",code);
        var itemTypeData = itemTypeFacade.getQualityLevelsByItemType(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(itemTypeData);
        return response;
    }
}
