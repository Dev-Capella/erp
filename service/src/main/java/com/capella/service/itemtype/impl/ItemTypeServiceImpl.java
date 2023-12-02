package com.capella.service.itemtype.impl;

import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.domain.model.unitofmeasure.UnitOfMeasureModel;
import com.capella.persistence.dao.itemtype.ItemTypeDao;
import com.capella.service.itemtype.ItemTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ItemTypeServiceImpl implements ItemTypeService {

    private final ItemTypeDao itemTypeDao;

    @Override
    public ItemTypeModel getItemTypeModel(String code) {
        var itemTypeModel = itemTypeDao.getByCode(code);
        return itemTypeModel;
    }

    @Override
    public Set<ItemTypeModel> getItemTypeModels() {
        List<ItemTypeModel> itemTypeModels = itemTypeDao.findAll();
        Set<ItemTypeModel> itemTypeModelSet = new HashSet<>(itemTypeModels);
        return itemTypeModelSet;
    }
}
