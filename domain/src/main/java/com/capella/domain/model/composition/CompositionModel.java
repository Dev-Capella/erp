package com.capella.domain.model.composition;

import com.capella.domain.model.compositiondetail.CompositionDetailModel;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Entity
@Table(name = "Composition")
@Getter
public class CompositionModel extends CodeBasedModel {
    public static final String COMPOSITION_RELATION = "composition_id";
    private String longText;
    private String shortText;
    private String searchText;
    private Boolean valid;

    @OneToMany
    @JoinTable(name="compositions_composition_details",
            joinColumns = @JoinColumn(name = COMPOSITION_RELATION), inverseJoinColumns = @JoinColumn(name = "composition_detail_id"))
    private Set<CompositionDetailModel> compositionDetails;

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    public void setCompositionDetails(Set<CompositionDetailModel> compositionDetails) {
        this.compositionDetails = compositionDetails;
    }
}
