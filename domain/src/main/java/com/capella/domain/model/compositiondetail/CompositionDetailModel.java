package com.capella.domain.model.compositiondetail;

import com.capella.domain.enums.CompositionUseType;
import com.capella.domain.enums.SubComposition;
import com.capella.domain.model.composition.CompositionModel;
import com.capella.domain.model.compositioncomponent.CompositionComponentModel;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "CompositionDetail")
@Getter
public class CompositionDetailModel extends CodeBasedModel {

    public static final String COMPOSITION_DETAIL_RELATION = "composition_detail_id";

    @Enumerated(EnumType.STRING)
    private SubComposition subComposition;
    @Enumerated(EnumType.STRING)
    private CompositionUseType useType;
    private int sequenceNumber;
    private BigDecimal percentage;
    private String longText;
    private String shortText;
    private String searchText;

    @ManyToOne
    @JoinTable(name="compositions_composition_details",
            joinColumns = @JoinColumn(name = COMPOSITION_DETAIL_RELATION), inverseJoinColumns = @JoinColumn(name = "composition_id"))
    private CompositionModel composition;

    @ManyToOne(fetch = FetchType.LAZY)
    private CompositionComponentModel compositionComponent;
    public void setSubComposition(SubComposition subComposition) {
        this.subComposition = subComposition;
    }

    public void setUseType(CompositionUseType useType) {
        this.useType = useType;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
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

    public void setComposition(CompositionModel composition) {
        this.composition = composition;
    }

    public void setCompositionComponent(CompositionComponentModel compositionComponent) {
        this.compositionComponent = compositionComponent;
    }
}
