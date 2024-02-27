package com.capella.domain.model.orderpartner;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.OrderPartnerType;
import com.capella.domain.model.area.AreaModel;
import com.capella.domain.model.businesspartner.BusinessPartnerModel;
import com.capella.domain.model.currency.CurrencyModel;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.market.MarketModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.ORDER_PARTNER_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.ORDER_PARTNER_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.ORDER_PARTNER_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class OrderPartnerModel extends CodeBasedModel{

    @Enumerated(EnumType.STRING)
    private OrderPartnerType orderPartnerType;

    @ManyToOne(fetch = FetchType.LAZY)
    private BusinessPartnerModel businessPartner;

    @ManyToOne(fetch = FetchType.LAZY)
    private CurrencyModel currency;

    private Boolean taxStampRequired;

    private Boolean requiredForCreditNote;

    private Boolean chargedOnCreditNote;

    @ManyToOne(fetch = FetchType.LAZY)
    private MarketModel market;

    @ManyToOne(fetch = FetchType.LAZY)
    private AreaModel area;
}
