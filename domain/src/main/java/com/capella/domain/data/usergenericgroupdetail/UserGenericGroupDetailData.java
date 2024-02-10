package com.capella.domain.data.usergenericgroupdetail;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.usergenericgroup.UserGenericGroupData;
import com.capella.domain.enums.UserGenericGroupDataType;
import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UserGenericGroupDetailData extends BaseDescriptionData {
    private UserGenericGroupData userGenericGroup;
}
