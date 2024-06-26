package com.capella.domain.model.cronjob;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.CronJobStatus;
import com.capella.domain.model.cronjoblog.CronJobLogModel;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = DomainConstant.CRONJOB_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.CRONJOB_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.CRONJOB_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class CronJobModel extends CodeBasedModel{
    public static final String CRONJOB_RELATION = "cronjob_id";
    private String longText;

    private String shortText;

    private String searchText;

    private String triggerPattern;

    private Date nextExecutionDate;

    @Enumerated(EnumType.STRING)
    private CronJobStatus status;

    @OneToMany
    @JoinTable(name="cronjob_cronjoblogs",
            joinColumns = @JoinColumn(name = CRONJOB_RELATION), inverseJoinColumns = @JoinColumn(name = CronJobLogModel.CRONJOB_LOG_RELATION))
    private Set<CronJobLogModel> cronJobLogs;
}
