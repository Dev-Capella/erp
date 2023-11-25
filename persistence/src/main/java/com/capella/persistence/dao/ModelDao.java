package com.capella.persistence.dao;

import com.capella.domain.model.base.ItemModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface ModelDao extends JpaRepository<ItemModel, Long> {
}
