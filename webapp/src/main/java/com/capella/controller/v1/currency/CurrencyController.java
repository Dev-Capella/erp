package com.capella.controller.v1.currency;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.currency.CurrencyData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.currency.CurrencyFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("currencyControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.CURRENCY)
@RequiredArgsConstructor
@Slf4j
public class CurrencyController {
    protected final CurrencyFacade currencyFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody CurrencyData currencyData){
        log.info("Inside save of CurrencyController",currencyData);
        currencyFacade.save(currencyData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of CurrencyController",code);
        var currencyData = currencyFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(currencyData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of CurrencyController");
        var currencyDatas = currencyFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(currencyDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of CurrencyController",code);
        currencyFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
