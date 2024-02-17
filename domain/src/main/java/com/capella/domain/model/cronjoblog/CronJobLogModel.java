package com.capella.domain.model.cronjoblog;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.CronJobStatus;
import com.capella.domain.model.counter.CounterModel;
import com.capella.domain.model.cronjob.CronJobModel;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.CRONJOB_LOG_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.CRONJOB_LOG_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.CRONJOB_LOG_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class CronJobLogModel extends CodeBasedModel{
    public static final String CRONJOB_LOG_RELATION = "cronjoblog_id";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="cronjob_cronjoblogs",
            joinColumns = @JoinColumn(name = CRONJOB_LOG_RELATION), inverseJoinColumns = @JoinColumn(name = CronJobModel.CRONJOB_RELATION))
    private CronJobModel cronJob;

    @Enumerated(EnumType.STRING)
    private CronJobStatus status;

    @Column(columnDefinition = "TEXT")
    private String logStatusDescription;
}
