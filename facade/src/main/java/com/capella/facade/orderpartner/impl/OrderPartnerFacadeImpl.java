package com.capella.facade.orderpartner.impl;

import com.capella.domain.data.orderpartner.OrderPartnerData;
import com.capella.domain.model.area.AreaModel;
import com.capella.domain.model.businesspartner.BusinessPartnerModel;
import com.capella.domain.model.currency.CurrencyModel;
import com.capella.domain.model.market.MarketModel;
import com.capella.domain.model.orderpartner.OrderPartnerModel;
import com.capella.facade.orderpartner.OrderPartnerFacade;
import com.capella.service.area.AreaService;
import com.capella.service.businesspartner.BusinessPartnerService;
import com.capella.service.currency.CurrencyService;
import com.capella.service.market.MarketService;
import com.capella.service.model.ModelService;
import com.capella.service.orderpartner.OrderPartnerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class OrderPartnerFacadeImpl implements OrderPartnerFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final BusinessPartnerService businessPartnerService;
    protected final CurrencyService currencyService;
    protected final MarketService marketService;
    protected final AreaService areaService;
    protected final OrderPartnerService orderPartnerService;

    @Override
    public void save(OrderPartnerData orderPartnerData) {
        OrderPartnerModel orderPartnerModel;
        if(orderPartnerData.isNew()){
            orderPartnerModel = modelMapper.map(orderPartnerData, OrderPartnerModel.class);
            orderPartnerModel.setCode(UUID.randomUUID().toString());
        }else{
            orderPartnerModel = orderPartnerService.getOrderPartnerModel(orderPartnerData.getCode());
            modelMapper.map(orderPartnerData, orderPartnerModel);
        }

        BusinessPartnerModel businessPartnerModel = null;
        if(Objects.nonNull(orderPartnerData.getBusinessPartner())){
            businessPartnerModel = businessPartnerService.getBusinessPartnerModel(orderPartnerData.getBusinessPartner().getCode());
        }
        orderPartnerModel.setBusinessPartner(businessPartnerModel);

        CurrencyModel currencyModel = null;
        if(Objects.nonNull(orderPartnerData.getCurrency())){
            currencyModel = currencyService.getCurrencyModel(orderPartnerData.getCurrency().getCode());
        }
        orderPartnerModel.setCurrency(currencyModel);

        MarketModel marketModel = null;
        if(Objects.nonNull(orderPartnerData.getMarket())){
            marketModel = marketService.getMarketModel(orderPartnerData.getMarket().getCode());
        }
        orderPartnerModel.setMarket(marketModel);

        AreaModel areaModel = null;
        if(Objects.nonNull(orderPartnerData.getArea())){
            areaModel = areaService.getAreaModel(orderPartnerData.getArea().getCode());
        }
        orderPartnerModel.setArea(areaModel);

        modelService.save(orderPartnerModel);
    }

    @Override
    public Set<OrderPartnerData> getAll() {
        var orderPartnerModels = orderPartnerService.getOrderPartnerModels();
        return Set.of(modelMapper.map(orderPartnerModels, OrderPartnerData[].class));
    }

    @Override
    public OrderPartnerData get(String code) {
        var orderPartnerModel = orderPartnerService.getOrderPartnerModel(code);
        return modelMapper.map(orderPartnerModel,OrderPartnerData.class);
    }

    @Override
    public void delete(String code) {
        var orderPartnerModel = orderPartnerService.getOrderPartnerModel(code);
        modelService.remove(orderPartnerModel);
    }
}
