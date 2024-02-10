package com.capella.facade.usergenericgroupdetail;

import com.capella.domain.data.usergenericgroupdetail.UserGenericGroupDetailData;

public interface UserGenericGroupDetailFacade {
    void save(UserGenericGroupDetailData userGenericGroupDetailData);
    void delete(String code);
    UserGenericGroupDetailData get(String code);
}
