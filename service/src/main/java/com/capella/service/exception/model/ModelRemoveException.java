package com.capella.service.exception.model;

import com.capella.service.exception.ErpRuntimeException;

public class ModelRemoveException extends ErpRuntimeException {
    public ModelRemoveException(String message, String messageKey, Object[] args) {
        super(message, messageKey, args);
    }

    public ModelRemoveException(String message) {
        super(message);
    }

    public ModelRemoveException(Throwable cause) {
        super(cause);
    }

    public ModelRemoveException(String message, Throwable cause) {
        super(message, cause);
    }
}
