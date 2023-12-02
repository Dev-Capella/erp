package com.capella.persistence.dao.itemtype;

import com.capella.domain.model.itemtype.ItemTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTypeDao extends JpaRepository<ItemTypeModel, Long> {
    ItemTypeModel getByCode(String code);

    List<ItemTypeModel> findAll();
}
