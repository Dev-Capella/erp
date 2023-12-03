package com.capella.facade.itemtype;

import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.data.qualitylevel.QualityLevelData;

import java.util.Set;

public interface ItemTypeFacade {
    void save(ItemTypeData itemTypeData);
    Set<ItemTypeData> getAll();
    ItemTypeData get(String code);
    void delete(String code);
    Set<ItemSubCodeData> getItemSubCodesByItemType(String code);
    Set<QualityLevelData> getQualityLevelsByItemType(String code);
}
