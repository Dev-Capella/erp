package com.capella.domain.data.orderpartner;

import com.capella.domain.data.area.AreaData;
import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.businesspartner.BusinessPartnerData;
import com.capella.domain.data.currency.CurrencyData;
import com.capella.domain.data.market.MarketData;
import com.capella.domain.enums.OrderPartnerType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class OrderPartnerData extends BaseDescriptionData {
    private OrderPartnerType orderPartnerType;
    private BusinessPartnerData businessPartner;
    private CurrencyData currency;
    private Boolean taxStampRequired;
    private Boolean requiredForCreditNote;
    private Boolean chargedOnCreditNote;
    private MarketData market;
    private AreaData area;
}
