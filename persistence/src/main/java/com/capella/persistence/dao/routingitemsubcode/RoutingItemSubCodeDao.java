package com.capella.persistence.dao.routingitemsubcode;

import com.capella.domain.model.routingitemsubcode.RoutingItemSubCodeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutingItemSubCodeDao extends JpaRepository<RoutingItemSubCodeModel, Long> {
    RoutingItemSubCodeModel getByCode(String code);
}
