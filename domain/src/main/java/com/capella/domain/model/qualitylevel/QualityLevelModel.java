package com.capella.domain.model.qualitylevel;

import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "QualityLevel")
@Getter
public class QualityLevelModel extends CodeBasedModel {

    private int level;

    private String longText;

    private String shortText;

    private String searchText;

    @ManyToOne
    private ItemTypeModel itemType;

    public void setLevel(int level) {
        this.level = level;
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

    public void setItemType(ItemTypeModel itemType) {
        this.itemType = itemType;
    }
}
