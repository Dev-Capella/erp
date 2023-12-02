package com.capella.domain.data.restservice;

import com.capella.domain.enums.ProcessStatus;
import lombok.Data;

@Data
public class ServiceResponseData {
    private ProcessStatus status;
    private String errorMessage;
    private String errorMessageDetail;
    private Object data;
}
