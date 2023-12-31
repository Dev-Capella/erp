package com.capella.domain.data.usergenericgroup;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.enums.UserGenericGroupDataType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UserGenericGroupData extends BaseDescriptionData {
    private int maxCodeLength;
    @Enumerated(EnumType.STRING)
    private UserGenericGroupDataType type;
}
