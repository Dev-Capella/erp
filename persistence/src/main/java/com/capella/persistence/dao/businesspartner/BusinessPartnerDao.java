package com.capella.persistence.dao.businesspartner;

import com.capella.domain.model.businesspartner.BusinessPartnerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessPartnerDao extends JpaRepository<BusinessPartnerModel, Long> {
    BusinessPartnerModel getByCode(String code);

    List<BusinessPartnerModel> findAll();
}
