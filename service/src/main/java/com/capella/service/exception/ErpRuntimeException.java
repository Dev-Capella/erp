package com.capella.service.exception;

import lombok.Getter;

@Getter
public class ErpRuntimeException extends RuntimeException{
    protected transient Object[] args;
    protected String messageKey;

    public ErpRuntimeException(String message, String messageKey, Object[] args){
        super(message);
        this.messageKey = messageKey;
        this.args = args;
    }

    public ErpRuntimeException(String message){
        super(message);
    }
    public ErpRuntimeException(Throwable cause){
        super(cause);
    }
    public ErpRuntimeException(String message, Throwable cause){
        super(message,cause);
    }

}
