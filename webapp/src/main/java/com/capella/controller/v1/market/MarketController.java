package com.capella.controller.v1.market;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.market.MarketData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.market.MarketFacade;
import com.capella.service.constant.ServiceConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("marketControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.MARKET)
@RequiredArgsConstructor
@Slf4j
public class MarketController {

    protected final MarketFacade marketFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody MarketData marketData){
        log.info("Inside save of MarketController",marketData);
        var data = marketFacade.save(marketData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(Map.of(ServiceConstant.CODE, data.getCode()));
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of MarketController",code);
        var marketData = marketFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(marketData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of MarketController");
        var marketDatas = marketFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(marketDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of MarketController",code);
        marketFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
