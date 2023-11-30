package com.capella.domain.model.itemtype;

import com.capella.domain.enums.ItemNature;
import com.capella.domain.enums.StatusAllowed;
import com.capella.domain.enums.Structer;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "ItemType")
@Getter
public class ItemTypeModel extends CodeBasedModel {

    @Enumerated(EnumType.STRING)
    private ItemNature itemNature;

    @Enumerated(EnumType.STRING)
    private StatusAllowed statusAllowed;

    @Enumerated(EnumType.STRING)
    private Structer structer;

    private Boolean sellingType;

    private Boolean valid;

    private Boolean managedByBox;

    private Boolean handleComponentStatus;

    private String longText;

    private String shortText;

    private String searchText;

    private Boolean qualityControlled;

    private Boolean lotControlled;

    private Boolean containerControlled;

    private Boolean elementControlled;

    private Boolean projectControlled;

    private Boolean statisticalGroupControlled;

    private Boolean costForStatisticalGroupControlled;

    private Boolean customerControlled;

    private Boolean supplierControlled;
}
