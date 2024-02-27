package com.capella.domain.model.country;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.ControlBankCheckType;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.COUNTRY_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.COUNTRY_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.COUNTRY_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class CountryModel extends CodeBasedModel{

    private String longText;

    private String shortText;

    private String searchText;

    private Boolean europeanCommunityMember;

    private Boolean euroCurrency;

    private Boolean iban;

    private Boolean validateIban;

    private Boolean sepa;

    private Boolean taxStampExcluded;

    @Enumerated(EnumType.STRING)
    private ControlBankCheckType controlBankCheckType;

    private String isoCode;

    private int internationalNumericCode;

    private int taxRegistrationNumberLength;

    private String firstAddressLine;

    private String secondAddressLine;

    private String thirdAddressLine;

    private String fourthAddressLine;

    private String fifthAddressLine;

    private String postalCode;

    private String town;

    private String district;
}
