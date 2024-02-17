package com.capella.domain.model.exchangerate;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.currency.CurrencyModel;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = DomainConstant.EXCHANGE_RATE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.EXCHANGE_RATE_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.EXCHANGE_RATE_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class ExchangeRateModel extends CodeBasedModel{

    public static final String EXCHANGE_RATE_RELATION = "exchange_rate_id";

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    private String bankNoteBuying;

    private String bankNoteSelling;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="currency_exchangerates",
            joinColumns = @JoinColumn(name = EXCHANGE_RATE_RELATION), inverseJoinColumns = @JoinColumn(name = CurrencyModel.CURRENCY_RELATION))
    private CurrencyModel currency;
}
