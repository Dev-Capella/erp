package com.capella.controller.v1.country;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.country.CountryData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.country.CountryFacade;
import com.capella.service.constant.ServiceConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("countryControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.COUNTRY)
@RequiredArgsConstructor
@Slf4j
public class CountryController {

    protected final CountryFacade countryFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody CountryData countryData){
        log.info("Inside save of CountryController",countryData);
        var data = countryFacade.save(countryData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(Map.of(ServiceConstant.CODE, data.getCode()));
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of CountryController",code);
        var countryData = countryFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(countryData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of CountryController");
        var countryDatas = countryFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(countryDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of CountryController",code);
        countryFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
