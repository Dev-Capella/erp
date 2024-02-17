package com.capella.domain.data.cronjob;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.enums.CronJobStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CronJobData extends BaseDescriptionData {
    private String triggerPattern;
    private CronJobStatus status;
    private Date nextExecutionDate;
}
