package com.capella.base.util;

import com.capella.base.exception.LocalizedException;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessagesUtils {
    @Getter
    @Setter
    private static Locale messagesLocale;

    public static String getMessageForLocale(String messageKey, Locale locale){
        return ResourceBundle.getBundle("messages",locale).getString(messageKey);
    }

    public static String getLocalizedMessageWithKey(String key){
        LocalizedException localizedException = new LocalizedException(key,
                getMessagesLocale()!=null ? getMessagesLocale() : Locale.getDefault());
        return localizedException.getLocalizedMessage();
    }
}
