package com.capella.service.exception.model;

import com.capella.service.exception.ErpRuntimeException;

public class ModelSaveException extends ErpRuntimeException {
    public ModelSaveException(String message, String messageKey, Object[] args) {
        super(message, messageKey, args);
    }

    public ModelSaveException(String message) {
        super(message);
    }

    public ModelSaveException(Throwable cause) {
        super(cause);
    }

    public ModelSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
