package com.capella.domain.data.paymentmethod;

import com.capella.domain.data.base.BaseDescriptionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class PaymentMethodData extends BaseDescriptionData {
    private Boolean paymentWithBills;
}
