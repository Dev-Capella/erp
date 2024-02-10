package com.capella.facade.usergenericgroup;

import com.capella.domain.data.compositiondetail.CompositionDetailData;
import com.capella.domain.data.unitofmeasure.UnitOfMeasureData;
import com.capella.domain.data.usergenericgroup.UserGenericGroupData;
import com.capella.domain.data.usergenericgroupdetail.UserGenericGroupDetailData;

import java.util.Set;

public interface UserGenericGroupFacade {
    void save(UserGenericGroupData userGenericGroupData);
    Set<UserGenericGroupData> getAll();
    UserGenericGroupData get(String code);
    void delete(String code);
    Set<UserGenericGroupDetailData> getUserGenericGroupDetailsByUserGenericGroup(String code);
}
