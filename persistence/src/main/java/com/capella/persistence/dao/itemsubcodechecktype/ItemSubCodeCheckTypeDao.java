package com.capella.persistence.dao.itemsubcodechecktype;

import com.capella.domain.model.itemsubcodechecktype.ItemSubCodeCheckTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemSubCodeCheckTypeDao extends JpaRepository<ItemSubCodeCheckTypeModel, Long> {
    ItemSubCodeCheckTypeModel getByCode(String code);
    List<ItemSubCodeCheckTypeModel> findAll();
}
