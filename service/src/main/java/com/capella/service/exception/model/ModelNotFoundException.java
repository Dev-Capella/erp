package com.capella.service.exception.model;

import com.capella.service.exception.ErpRuntimeException;

public class ModelNotFoundException extends ErpRuntimeException {
    public ModelNotFoundException(String message, String messageKey, Object[] args) {
        super(message, messageKey, args);
    }

    public ModelNotFoundException(String message) {
        super(message);
    }

    public ModelNotFoundException(Throwable cause) {
        super(cause);
    }

    public ModelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
