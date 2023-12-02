package com.capella.service.itemsubcode.impl;

import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import com.capella.persistence.dao.itemsubcode.ItemSubCodeDao;
import com.capella.service.itemsubcode.ItemSubCodeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ItemSubCodeServiceImpl implements ItemSubCodeService {

    private final ItemSubCodeDao itemSubCodeDao;
    @Override
    public ItemSubCodeModel getItemSubCodeModel(String code) {
        var itemSubCodeModel = itemSubCodeDao.getByCode(code);
        return itemSubCodeModel;
    }
}
