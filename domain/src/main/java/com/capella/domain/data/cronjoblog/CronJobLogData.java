package com.capella.domain.data.cronjoblog;

import com.capella.domain.data.base.BaseData;
import com.capella.domain.enums.CronJobStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CronJobLogData extends BaseData {
    private CronJobStatus status;
    private String logStatusDescription;
    private Date createdDate;
}
