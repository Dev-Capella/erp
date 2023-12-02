package com.capella.persistence.dao.itemsubcode;

import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemSubCodeDao extends JpaRepository<ItemSubCodeModel, Long> {
    ItemSubCodeModel getByCode(String code);
}
