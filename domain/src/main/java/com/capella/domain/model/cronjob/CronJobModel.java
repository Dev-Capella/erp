package com.capella.domain.model.cronjob;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.CronJobStatus;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.CRONJOB_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.CRONJOB_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.CRONJOB_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class CronJobModel extends CodeBasedModel{

    private String longText;

    private String shortText;

    private String searchText;

    private String triggerPattern;

    @Enumerated(EnumType.STRING)
    private CronJobStatus status;
}
