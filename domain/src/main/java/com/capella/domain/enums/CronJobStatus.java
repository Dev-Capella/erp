package com.capella.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CronJobStatus {
    NEW,
    RUNNING,
    SUCCESSFUL,
    FAILED,
    STARTED,
    STOPPED;
}
