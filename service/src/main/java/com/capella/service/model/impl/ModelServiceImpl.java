package com.capella.service.model.impl;

import com.capella.base.util.ErpClassUtils;
import com.capella.domain.model.extend.ItemModel;
import com.capella.persistence.dao.model.ModelDao;
import com.capella.service.interceptor.Interceptor;
import com.capella.service.interceptor.registry.InterceptorRegistry;
import com.capella.service.model.ModelService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    protected final ModelDao modelDao;
    protected final InterceptorRegistry interceptorRegistry;

    @Override
    public <T extends ItemModel> T save(T t) {
        try {
            runBeforeInterceptors(t, Transaction.SAVE);
            var model = modelDao.save(t);
            model.setModifiedAttributes(t.getModifiedAttributes());
            runAfterInterceptors(t, Transaction.SAVE);
            return model;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public <T extends ItemModel> Iterable<T> saveAll(Iterable<T> t) {
        try {
            for(T item: t){
                runBeforeInterceptors(item, Transaction.SAVE);
            }
            var models = modelDao.saveAll(t);
            models.stream().forEach(m -> m.setModifiedAttributes(t.iterator().next().getModifiedAttributes()));
            for(T item: t){
                runAfterInterceptors(item, Transaction.SAVE);
            }
            return models;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public <T extends ItemModel> Iterable<T> saveAll(T... t) {
        try {
            for(T item: t){
                runBeforeInterceptors(item, Transaction.SAVE);
            }
            var models = modelDao.saveAll(Arrays.asList(t));

            for(T item: t){
                runAfterInterceptors(item, Transaction.SAVE);
            }
            return models;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public <T extends ItemModel> void remove(T t) {
        try {
            runBeforeInterceptors(t, Transaction.REMOVE);
            modelDao.delete(t);
            runAfterInterceptors(t, Transaction.REMOVE);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public <T extends ItemModel> void removeAll(Iterable<T> t) {
        try {
            for(T item: t){
                runBeforeInterceptors(item, Transaction.REMOVE);
            }
            modelDao.deleteAll(t);
            for(T item: t){
                runAfterInterceptors(item, Transaction.REMOVE);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public <T extends ItemModel> void removeAll(T... t) {
        try {
            for(T item: t){
                runBeforeInterceptors(item, Transaction.REMOVE);
            }
            var list = Arrays.asList(t);
            modelDao.deleteAll(list);
            for(T item: t){
                runAfterInterceptors(item, Transaction.REMOVE);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    protected <T extends ItemModel> void runBeforeInterceptors(T t, Transaction transaction) {
        var interceptor = StringUtils.EMPTY;
        try {
            if (Transaction.REMOVE.equals(transaction)) {
                var beforeRemoveInterceptors = interceptorRegistry.getBeforeRemoveInterceptor().entrySet().stream()
                        .filter(p -> StringUtils.equals(p.getValue().getTypeName(), t.getClass().getTypeName()))
                        .map(Map.Entry::getKey).toList();

                for (Interceptor<T> p : beforeRemoveInterceptors) {
                    interceptor = ErpClassUtils.getSimpleName(p);
                    p.invoke(t);
                }
            } else if (Transaction.SAVE.equals(transaction)) {
                if (Objects.isNull(t.getId()) || t.getId() == 0) {
                    t.setNewTransaction(Boolean.TRUE);
                }
                var beforeSaveInterceptors = interceptorRegistry.getBeforeSaveInterceptor().entrySet().stream()
                        .filter(p -> StringUtils.equals(p.getValue().getTypeName(), t.getClass().getTypeName()))
                        .map(Map.Entry::getKey).toList();

                for (Interceptor<T> p : beforeSaveInterceptors) {
                    interceptor = ErpClassUtils.getSimpleName(p);
                    p.invoke(t);
                }
            }
        } catch (final Exception e) {


        }

    }

    protected <T extends ItemModel> void runAfterInterceptors(T t, Transaction transaction)  {
        var interceptor = StringUtils.EMPTY;
        try {
            if (Transaction.REMOVE.equals(transaction)) {
                var afterRemoveInterceptors = interceptorRegistry.getAfterRemoveInterceptor().entrySet().stream()
                        .filter(p -> StringUtils.equals(p.getValue().getTypeName(), t.getClass().getTypeName()))
                        .map(Map.Entry::getKey).collect(Collectors.toList());

                for (Interceptor<T> p : afterRemoveInterceptors) {
                    interceptor = ErpClassUtils.getSimpleName(p);
                    p.invoke(t);
                }
            } else if (Transaction.SAVE.equals(transaction)) {
                var afterSaveInterceptors = interceptorRegistry.getAfterSaveInterceptor().entrySet().stream()
                        .filter(p -> StringUtils.equals(p.getValue().getTypeName(), t.getClass().getTypeName()))
                        .map(Map.Entry::getKey).collect(Collectors.toList());

                for (Interceptor<T> p : afterSaveInterceptors) {
                    interceptor = ErpClassUtils.getSimpleName(p);
                    p.invoke(t);
                }
            }
        } catch (final Exception e) {

        }


    }
    enum Transaction {
        SAVE, REMOVE
    }
}
