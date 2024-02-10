package com.capella.domain.model.usergenericgroupdetail;

import com.capella.domain.enums.UserGenericGroupDataType;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UserGenericGroupDetail")
@Getter
@Setter
public class UserGenericGroupDetailModel extends CodeBasedModel {

    public static final String USER_GENERIC_GROUP_DETAIL_RELATION = "user_generic_group_detail_id";

    private String longText;
    private String shortText;
    private String searchText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="user_generic_group_user_generic_group_details",
            joinColumns = @JoinColumn(name = USER_GENERIC_GROUP_DETAIL_RELATION), inverseJoinColumns = @JoinColumn(name = UserGenericGroupModel.USER_GENERIC_GROUP_RELATION))
    private UserGenericGroupModel userGenericGroup;

}
