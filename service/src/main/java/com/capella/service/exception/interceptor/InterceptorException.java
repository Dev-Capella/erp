package com.capella.service.exception.interceptor;

import com.capella.service.exception.ErpRuntimeException;

public class InterceptorException extends ErpRuntimeException {
    public InterceptorException(String message, String messageKey, Object[] args) {
        super(message, messageKey, args);
    }

    public InterceptorException(String message) {
        super(message);
    }

    public InterceptorException(Throwable cause) {
        super(cause);
    }

    public InterceptorException(String message, Throwable cause) {
        super(message, cause);
    }
}
