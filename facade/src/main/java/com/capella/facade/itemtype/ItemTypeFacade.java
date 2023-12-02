package com.capella.facade.itemtype;

import com.capella.domain.data.itemtype.ItemTypeData;
import java.util.Set;

public interface ItemTypeFacade {
    void save(ItemTypeData itemTypeData);
    Set<ItemTypeData> getAll();
    ItemTypeData get(String code);
    void delete(String code);
}
