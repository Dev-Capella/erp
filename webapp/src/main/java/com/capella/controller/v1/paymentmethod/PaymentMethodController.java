package com.capella.controller.v1.paymentmethod;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.paymentmethod.PaymentMethodData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.paymentmethod.PaymentMethodFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("paymentMethodControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.PAYMENTMETHOD)
@RequiredArgsConstructor
@Slf4j
public class PaymentMethodController {

    protected final PaymentMethodFacade paymentMethodFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody PaymentMethodData paymentMethodData){
        log.info("Inside save of PaymentMethodController",paymentMethodData);
        paymentMethodFacade.save(paymentMethodData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of PaymentMethodController",code);
        var paymentMethodData = paymentMethodFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(paymentMethodData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of PaymentMethodController");
        var paymentMethodDatas = paymentMethodFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(paymentMethodDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of PaymentMethodController",code);
        paymentMethodFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
