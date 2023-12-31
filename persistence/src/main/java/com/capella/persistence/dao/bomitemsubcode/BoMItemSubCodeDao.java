package com.capella.persistence.dao.bomitemsubcode;

import com.capella.domain.model.bomitemsubcode.BoMItemSubCodeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoMItemSubCodeDao extends JpaRepository<BoMItemSubCodeModel, Long> {
    BoMItemSubCodeModel getByCode(String code);
}
