package com.capella.domain.model.ItemSubCode;

import com.capella.domain.enums.ItemSubCodeDataType;
import com.capella.domain.enums.ItemSubCodeType;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "ItemSubCode")
@Getter
public class ItemSubCodeModel extends CodeBasedModel {

    private int position;

    private int length;

    @Enumerated(EnumType.STRING)
    private ItemSubCodeType type;

    private Boolean mandatory;

    @Enumerated(EnumType.STRING)
    private ItemSubCodeDataType itemSubCodeDataType;

    private String longText;

    private String shortText;

    private String searchText;

    private char outputSeparator;

    private Boolean wareHouseManagement;

    private Boolean costManagement;

}
