package com.capella.service.interceptor;

import com.capella.domain.model.extend.ItemModel;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
@Component
public @interface BeforeSaveInterceptor {
    @AliasFor(annotation = Component.class)
    String value() default "";
    Class<? extends ItemModel> itemType();
}
