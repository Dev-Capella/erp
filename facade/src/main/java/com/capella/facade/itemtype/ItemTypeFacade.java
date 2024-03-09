package com.capella.facade.itemtype;

import com.capella.domain.data.bomitemsubcode.BoMItemSubCodeData;
import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.data.productitemsubcode.ProductItemSubCodeData;
import com.capella.domain.data.qualitylevel.QualityLevelData;
import com.capella.domain.data.routingitemsubcode.RoutingItemSubCodeData;

import java.util.Set;

public interface ItemTypeFacade {
    ItemTypeData save(ItemTypeData itemTypeData);
    Set<ItemTypeData> getAll();
    ItemTypeData get(String code);
    void delete(String code);
    Set<ItemSubCodeData> getItemSubCodesByItemType(String code);
    Set<QualityLevelData> getQualityLevelsByItemType(String code);
    Set<RoutingItemSubCodeData> getRoutingItemSubCodesByItemType(String code);
    Set<BoMItemSubCodeData> getBoMItemSubCodesByItemType(String code);
    Set<ProductItemSubCodeData> getItemSubCodesByItemTypeForProduct(String code);
}
