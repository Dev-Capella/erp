package com.capella.domain.model.unitofmeasure;

import com.capella.domain.enums.UnitOfMeasureType;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UnitOfMeasure")
@Getter
public class UnitOfMeasureModel extends CodeBasedModel {

    private String longText;

    private String shortText;

    private String searchText;

    @Enumerated(EnumType.STRING)
    private UnitOfMeasureType unitOfMeasureType;


    public void setLongText(String longText) {
        this.longText = longText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public void setUnitOfMeasureType(UnitOfMeasureType unitOfMeasureType) {
        this.unitOfMeasureType = unitOfMeasureType;
    }
}
