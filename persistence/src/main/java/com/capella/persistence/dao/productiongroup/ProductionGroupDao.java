package com.capella.persistence.dao.productiongroup;

import com.capella.domain.model.productiongroup.ProductionGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductionGroupDao extends JpaRepository<ProductionGroupModel, Long> {
    ProductionGroupModel getByCode(String code);

    List<ProductionGroupModel> findAll();
}
