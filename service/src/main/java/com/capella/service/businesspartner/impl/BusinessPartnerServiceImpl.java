package com.capella.service.businesspartner.impl;

import com.capella.domain.model.businesspartner.BusinessPartnerModel;
import com.capella.persistence.dao.businesspartner.BusinessPartnerDao;
import com.capella.service.businesspartner.BusinessPartnerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class BusinessPartnerServiceImpl implements BusinessPartnerService {

    private final BusinessPartnerDao businessPartnerDao;

    @Override
    public BusinessPartnerModel getBusinessPartnerModel(String code) {
        var businessPartnerModel = businessPartnerDao.getByCode(code);
        return businessPartnerModel;
    }

    @Override
    public Set<BusinessPartnerModel> getBusinessPartnerModels() {
        List<BusinessPartnerModel> businessPartnerModels = businessPartnerDao.findAll();
        Set<BusinessPartnerModel> businessPartnerModelSet = new HashSet<>(businessPartnerModels);
        return businessPartnerModelSet;
    }
}
