package com.capella.persistence.dao.washsymbol;

import com.capella.domain.model.washsymbol.WashSymbolModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WashSymbolDao extends JpaRepository<WashSymbolModel, Long> {
    WashSymbolModel getByCode(String code);
    List<WashSymbolModel> findAll();
}
