package com.capella.persistence.dao.usergenericgroupdetail;

import com.capella.domain.model.usergenericgroupdetail.UserGenericGroupDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGenericGroupDetailDao extends JpaRepository<UserGenericGroupDetailModel, Long> {
    UserGenericGroupDetailModel getByCode(String code);
}
