package com.capella.domain.model.usergenericgroup;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.UserGenericGroupDataType;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.qualitylevel.QualityLevelModel;
import com.capella.domain.model.usergenericgroupdetail.UserGenericGroupDetailModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = DomainConstant.USER_GENERIC_GROUP_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.USER_GENERIC_GROUP_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.USER_GENERIC_GROUP_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class UserGenericGroupModel extends CodeBasedModel {

    public static final String USER_GENERIC_GROUP_RELATION = "user_generic_group_id";

    private int maxCodeLength;
    @Enumerated(EnumType.STRING)
    private UserGenericGroupDataType type;
    private String longText;
    private String shortText;
    private String searchText;

    @OneToMany
    @JoinTable(name="user_generic_group_user_generic_group_details",
            joinColumns = @JoinColumn(name = USER_GENERIC_GROUP_RELATION), inverseJoinColumns = @JoinColumn(name = UserGenericGroupDetailModel.USER_GENERIC_GROUP_DETAIL_RELATION))
    private Set<UserGenericGroupDetailModel> userGenericGroupDetails;
}
