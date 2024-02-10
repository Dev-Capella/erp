package com.capella.service.interceptor.registry;

import com.capella.domain.model.extend.ItemModel;
import com.capella.service.interceptor.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Getter
@AllArgsConstructor
public class InterceptorRegistry {
    protected final ApplicationContext context;

    public Map<Interceptor, Class<? extends ItemModel>> beforeSaveInterceptor;
    public Map<Interceptor, Class<? extends ItemModel>> beforeRemoveInterceptor;
    public Map<Interceptor, Class<? extends ItemModel>> afterSaveInterceptor;
    public Map<Interceptor, Class<? extends ItemModel>> afterRemoveInterceptor;

    @Bean(name = "registerAllInterceptors")
    void registerAllInterceptors() {
        context.getBeansWithAnnotation(BeforeSaveInterceptor.class).entrySet().stream().forEach(interceptor -> {
            var annotation = interceptor.getValue().getClass().getAnnotation(BeforeSaveInterceptor.class);
            beforeSaveInterceptor.put((Interceptor) interceptor.getValue(), annotation.itemType());
        });

        context.getBeansWithAnnotation(BeforeRemoveInterceptor.class).entrySet().stream().forEach(interceptor -> {
            var annotation = interceptor.getValue().getClass().getAnnotation(BeforeRemoveInterceptor.class);
            beforeRemoveInterceptor.put((Interceptor) interceptor.getValue(), annotation.itemType());
        });

        context.getBeansWithAnnotation(AfterSaveInterceptor.class).entrySet().stream().forEach(interceptor -> {
            var annotation = interceptor.getValue().getClass().getAnnotation(AfterSaveInterceptor.class);
            afterSaveInterceptor.put((Interceptor) interceptor.getValue(), annotation.itemType());
        });

        context.getBeansWithAnnotation(AfterRemoveInterceptor.class).entrySet().stream().forEach(interceptor -> {
            var annotation = interceptor.getValue().getClass().getAnnotation(AfterRemoveInterceptor.class);
            afterRemoveInterceptor.put((Interceptor) interceptor.getValue(), annotation.itemType());
        });

    }
}
