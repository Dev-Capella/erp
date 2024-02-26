package com.capella.domain.data.policycheck;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.policycheckcategory.PolicyCheckCategoryData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class PolicyCheckData extends BaseDescriptionData {
    private String policy;
    private PolicyCheckCategoryData policyCheckCategory;
}
