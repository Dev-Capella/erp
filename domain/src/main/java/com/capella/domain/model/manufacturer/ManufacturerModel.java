package com.capella.domain.model.manufacturer;

import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.media.MediaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "Manufacturer")
@Getter
public class ManufacturerModel extends CodeBasedModel {

    private String name;
    private String longText;
    private String shortText;
    private String searchText;

    @ManyToOne
    private MediaModel media;

    public void setName(String name) {
        this.name = name;
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

    public void setMedia(MediaModel media) {
        this.media = media;
    }
}
