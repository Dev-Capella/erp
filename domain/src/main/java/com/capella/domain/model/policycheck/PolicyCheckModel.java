package com.capella.domain.model.policycheck;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.policycheckcategory.PolicyCheckCategoryModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.POLICY_CHECK_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.POLICY_CHECK_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.POLICY_CHECK_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class PolicyCheckModel extends CodeBasedModel {

    private String longText;

    private String shortText;

    private String searchText;

    private String policy;

    @ManyToOne(fetch = FetchType.LAZY)
    private PolicyCheckCategoryModel policyCheckCategory;
}
