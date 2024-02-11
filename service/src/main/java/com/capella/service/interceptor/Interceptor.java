package com.capella.service.interceptor;

import com.capella.domain.model.extend.ItemModel;
import com.capella.service.exception.interceptor.InterceptorException;
import org.apache.commons.lang3.StringUtils;

public interface Interceptor<T extends ItemModel> {
    void invoke(T model) throws InterceptorException;

    default boolean isNew(T model){
        return model.isNewTransaction();
    }

    default boolean isModified(T model, String attribute){
        return model.getModifiedAttributes().stream().anyMatch(p -> StringUtils.equals(p, attribute));
    }
}
