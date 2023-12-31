package com.capella.domain.model.usergenericgroup;

import com.capella.domain.enums.UserGenericGroupDataType;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "UserGenericGroup")
@Getter
public class UserGenericGroupModel extends CodeBasedModel {
    private int maxCodeLength;
    @Enumerated(EnumType.STRING)
    private UserGenericGroupDataType type;
    private String longText;
    private String shortText;
    private String searchText;

    public void setMaxCodeLength(int maxCodeLength) {
        this.maxCodeLength = maxCodeLength;
    }

    public void setType(UserGenericGroupDataType type) {
        this.type = type;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
