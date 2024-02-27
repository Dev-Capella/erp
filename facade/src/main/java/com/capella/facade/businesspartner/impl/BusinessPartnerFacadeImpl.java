package com.capella.facade.businesspartner.impl;

import com.capella.domain.data.businesspartner.BusinessPartnerData;
import com.capella.domain.model.businesspartner.BusinessPartnerModel;
import com.capella.facade.businesspartner.BusinessPartnerFacade;
import com.capella.service.businesspartner.BusinessPartnerService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class BusinessPartnerFacadeImpl implements BusinessPartnerFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final BusinessPartnerService businessPartnerService;

    @Override
    public void save(BusinessPartnerData businessPartnerData) {
        BusinessPartnerModel businessPartnerModel;
        if(businessPartnerData.isNew()){
            businessPartnerModel = modelMapper.map(businessPartnerData, BusinessPartnerModel.class);
            businessPartnerModel.setCode(UUID.randomUUID().toString());
        }else{
            businessPartnerModel = businessPartnerService.getBusinessPartnerModel(businessPartnerData.getCode());
            modelMapper.map(businessPartnerData, businessPartnerModel);
        }
        modelService.save(businessPartnerModel);
    }

    @Override
    public Set<BusinessPartnerData> getAll() {
        var businessPartnerModels = businessPartnerService.getBusinessPartnerModels();
        return Set.of(modelMapper.map(businessPartnerModels, BusinessPartnerData[].class));
    }

    @Override
    public BusinessPartnerData get(String code) {
        var businessPartnerModel = businessPartnerService.getBusinessPartnerModel(code);
        return modelMapper.map(businessPartnerModel,BusinessPartnerData.class);
    }

    @Override
    public void delete(String code) {
        var businessPartnerModel = businessPartnerService.getBusinessPartnerModel(code);
        modelService.remove(businessPartnerModel);
    }
}
