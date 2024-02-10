package com.capella.domain.model.itemsubcodechecktype;

import com.capella.domain.enums.CheckType;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ItemSubCodeCheckType")
@Getter
@Setter
public class ItemSubCodeCheckTypeModel extends CodeBasedModel {
    private String longText;
    private String shortText;
    private String searchText;
    private String relatedItem;
    @Enumerated(EnumType.STRING)
    private CheckType checkType;
}
