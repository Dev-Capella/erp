package com.capella.facade.itemsubcodechecktype;

import com.capella.domain.data.itemsubcodechecktype.ItemSubCodeCheckTypeData;
import com.capella.domain.data.itemsubcodechecktype.PLItemSubCodeCheckTypeData;

import java.util.Set;

public interface ItemSubCodeCheckTypeFacade {
    void save(ItemSubCodeCheckTypeData itemSubCodeCheckTypeData);
    Set<ItemSubCodeCheckTypeData> getAll();
    ItemSubCodeCheckTypeData get(String code);
    void delete(String code);
    PLItemSubCodeCheckTypeData getItemSubCodeCheckTypeByPolicyFacade(String code);

}
