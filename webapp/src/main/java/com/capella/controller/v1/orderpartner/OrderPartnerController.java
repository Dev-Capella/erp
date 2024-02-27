package com.capella.controller.v1.orderpartner;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.orderpartner.OrderPartnerData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.orderpartner.OrderPartnerFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("orderPartnerControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.ORDERPARTNER)
@RequiredArgsConstructor
@Slf4j
public class OrderPartnerController {

    protected final OrderPartnerFacade orderPartnerFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody OrderPartnerData orderPartnerData){
        log.info("Inside save of OrderPartnerController",orderPartnerData);
        orderPartnerFacade.save(orderPartnerData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of OrderPartnerController",code);
        var orderPartnerData = orderPartnerFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(orderPartnerData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of OrderPartnerController");
        var orderPartnerDatas = orderPartnerFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(orderPartnerDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of OrderPartnerController",code);
        orderPartnerFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
