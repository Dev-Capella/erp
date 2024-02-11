package com.capella.base.exception;

import com.capella.base.util.MessagesUtils;

import java.util.Locale;

public class LocalizedException extends Exception{
    private final String messageKey;
    private final Locale locale;

    public LocalizedException(String messageKey){
        this(messageKey, Locale.getDefault());
    }

    public LocalizedException(String messageKey, Locale locale){
        this.messageKey = messageKey;
        this.locale = locale;
    }

    @Override
    public String getLocalizedMessage() {
        return MessagesUtils.getMessageForLocale(messageKey, locale);
    }
}
