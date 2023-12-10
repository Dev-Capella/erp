package com.capella.facade.itemsubcode;

import com.capella.domain.data.itemsubcode.ItemSubCodeData;

public interface ItemSubCodeFacade {
    void save(ItemSubCodeData itemSubCodeData);
    void delete(String code);
    ItemSubCodeData get(String code);

}
