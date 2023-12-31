package com.capella.facade.routingitemsubcode;
import com.capella.domain.data.routingitemsubcode.RoutingItemSubCodeData;

public interface RoutingItemSubCodeFacade {
    void save(RoutingItemSubCodeData routingItemSubCodeData);
    void delete(String code);
    RoutingItemSubCodeData get(String code);
}
