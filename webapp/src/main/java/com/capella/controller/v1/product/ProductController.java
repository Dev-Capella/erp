package com.capella.controller.v1.product;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.product.ProductData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.product.ProductFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("productControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.PRODUCT)
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    protected final ProductFacade productFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody ProductData productData){
        log.info("Inside save of ProductController",productData);
        productFacade.save(productData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of ProductController",code);
        var productData = productFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(productData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of ProductController");
        var productDatas = productFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(productDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of ProductController",code);
        productFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
