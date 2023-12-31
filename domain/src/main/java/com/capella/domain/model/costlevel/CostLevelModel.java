package com.capella.domain.model.costlevel;

import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "CostLevel")
@Getter
public class CostLevelModel extends CodeBasedModel {
    private String longText;
    private String shortText;
    private String searchText;

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
