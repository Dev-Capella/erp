package com.capella.domain.model.manufacturer;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.media.MediaModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.MANUFACTURER_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.MANUFACTURER_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.MANUFACTURER_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class ManufacturerModel extends CodeBasedModel {

    private String name;
    private String longText;
    private String shortText;
    private String searchText;

    @ManyToOne(fetch = FetchType.LAZY)
    private MediaModel media;
}
