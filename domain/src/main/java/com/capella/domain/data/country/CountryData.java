package com.capella.domain.data.country;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.enums.ControlBankCheckType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CountryData extends BaseDescriptionData {
    private Boolean europeanCommunityMember;
    private Boolean euroCurrency;
    private Boolean iban;
    private Boolean validateIban;
    private Boolean sepa;
    private Boolean taxStampExcluded;
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
