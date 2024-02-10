package com.capella.service.itemsubcodechecktype.impl;

import com.capella.domain.model.costlevel.CostLevelModel;
import com.capella.domain.model.itemsubcodechecktype.ItemSubCodeCheckTypeModel;
import com.capella.persistence.dao.itemsubcodechecktype.ItemSubCodeCheckTypeDao;
import com.capella.service.itemsubcodechecktype.ItemSubCodeCheckTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ItemSubCodeCheckTypeServiceImpl implements ItemSubCodeCheckTypeService {
    private final ItemSubCodeCheckTypeDao itemSubCodeCheckTypeDao;
    @Override
    public ItemSubCodeCheckTypeModel getItemSubCodeCheckTypeModel(String code) {
        var itemSubCodeCheckTypeModel = itemSubCodeCheckTypeDao.getByCode(code);
        return itemSubCodeCheckTypeModel;
    }

    @Override
    public Set<ItemSubCodeCheckTypeModel> getItemSubCodeCheckTypeModels() {
        List<ItemSubCodeCheckTypeModel> itemSubCodeCheckTypeModels = itemSubCodeCheckTypeDao.findAll();
        Set<ItemSubCodeCheckTypeModel> itemSubCodeCheckTypeModelSet = new HashSet<>(itemSubCodeCheckTypeModels);
        return itemSubCodeCheckTypeModelSet;
    }
}
