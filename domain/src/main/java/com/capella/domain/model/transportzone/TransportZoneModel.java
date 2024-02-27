package com.capella.domain.model.transportzone;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.country.CountryModel;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.MARKET_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.MARKET_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.MARKET_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class TransportZoneModel extends CodeBasedModel {

    private String longText;

    private String shortText;

    private String searchText;

    @ManyToOne(fetch = FetchType.LAZY)
    private CountryModel country;
}
