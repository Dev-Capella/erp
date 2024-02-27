package com.capella.domain.model.businesspartner;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.BUSINESS_PARTNER_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.BUSINESS_PARTNER_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.BUSINESS_PARTNER_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class BusinessPartnerModel extends CodeBasedModel{
}
