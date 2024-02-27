package com.capella.service.businesspartner;

import com.capella.domain.model.businesspartner.BusinessPartnerModel;

import java.util.Set;

public interface BusinessPartnerService {
    BusinessPartnerModel getBusinessPartnerModel(String code);
    Set<BusinessPartnerModel> getBusinessPartnerModels();
}
