package com.capella.persistence.dao.model;

import com.capella.domain.model.extend.ItemModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface ModelDao extends JpaRepository<ItemModel, Long> {
}
