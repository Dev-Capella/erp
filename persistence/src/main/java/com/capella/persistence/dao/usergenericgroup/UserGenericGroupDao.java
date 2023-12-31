package com.capella.persistence.dao.usergenericgroup;

import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserGenericGroupDao  extends JpaRepository<UserGenericGroupModel, Long> {
    UserGenericGroupModel getByCode(String code);
    List<UserGenericGroupModel> findAll();
}
