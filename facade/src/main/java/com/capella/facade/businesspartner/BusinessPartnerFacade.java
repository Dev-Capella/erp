package com.capella.facade.businesspartner;

import com.capella.domain.data.businesspartner.BusinessPartnerData;

import java.util.Set;

public interface BusinessPartnerFacade {
    void save(BusinessPartnerData businessPartnerData);
    Set<BusinessPartnerData> getAll();
    BusinessPartnerData get(String code);
    void delete(String code);
}
