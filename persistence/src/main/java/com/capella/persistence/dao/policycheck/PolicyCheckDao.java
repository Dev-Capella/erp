package com.capella.persistence.dao.policycheck;

import com.capella.domain.model.policycheck.PolicyCheckModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyCheckDao extends JpaRepository<PolicyCheckModel, Long> {

    PolicyCheckModel getByCode(String code);

    List<PolicyCheckModel> findAll();
}
