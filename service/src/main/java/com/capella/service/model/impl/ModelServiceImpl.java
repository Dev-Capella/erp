package com.capella.service.model.impl;

import com.capella.base.util.ErpClassUtils;
import com.capella.domain.model.extend.ItemModel;
import com.capella.persistence.dao.model.ModelDao;
import com.capella.service.exception.ErpRuntimeException;
import com.capella.service.exception.interceptor.InterceptorException;
import com.capella.service.exception.model.ModelRemoveException;
import com.capella.service.exception.model.ModelSaveException;
import com.capella.service.interceptor.Interceptor;
import com.capella.service.interceptor.registry.InterceptorRegistry;
import com.capella.service.model.ModelService;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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
            var errorMessage = getValidatorMessageWhenSave(e);
            if(e instanceof ErpRuntimeException){
                throw ((ErpRuntimeException) e);
            }
            throw new ModelSaveException(errorMessage);
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
            var errorMessage = getValidatorMessageWhenSave(e);
            if(e instanceof ErpRuntimeException){
                throw ((ErpRuntimeException) e);
            }
            throw new ModelSaveException(errorMessage);
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
            var errorMessage = getValidatorMessageWhenSave(e);
            if(e instanceof ErpRuntimeException){
                throw ((ErpRuntimeException) e);
            }
            throw new ModelSaveException(errorMessage);
        }

    }

    @Override
    public <T extends ItemModel> void remove(T t) {
        try {
            runBeforeInterceptors(t, Transaction.REMOVE);
            modelDao.delete(t);
            runAfterInterceptors(t, Transaction.REMOVE);
        } catch (Exception e) {
            var errorMessage = getValidatorMessageWhenSave(e);
            if(e instanceof ErpRuntimeException){
                throw ((ErpRuntimeException) e);
            }
            throw new ModelRemoveException(errorMessage);
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
            var errorMessage = getValidatorMessageWhenSave(e);
            if(e instanceof ErpRuntimeException){
                throw ((ErpRuntimeException) e);
            }
            throw new ModelRemoveException(errorMessage);
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
            var errorMessage = getValidatorMessageWhenSave(e);
            if(e instanceof ErpRuntimeException){
                throw ((ErpRuntimeException) e);
            }
            throw new ModelRemoveException(errorMessage);
        }

    }

    @Override
    public <T extends ItemModel> T create(Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor().newInstance();
        }catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            throw new ClassCastException();
        }
    }

    protected <T extends ItemModel> void runBeforeInterceptors(T t, Transaction transaction) throws InterceptorException {
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
            if(e instanceof InterceptorException){
                throw new InterceptorException("Interceptor : " + interceptor + StringUtils.SPACE + ExceptionUtils.getMessage(e), ((InterceptorException) e).getMessageKey(), ((InterceptorException) e).getArgs());
            }else{
                throw new InterceptorException("Interceptor : " + interceptor + StringUtils.SPACE + ExceptionUtils.getMessage(e));
            }
        }

    }

    protected <T extends ItemModel> void runAfterInterceptors(T t, Transaction transaction) throws InterceptorException  {
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
            if(e instanceof InterceptorException){
                throw new InterceptorException("Interceptor : " + interceptor + StringUtils.SPACE + ExceptionUtils.getMessage(e), ((InterceptorException) e).getMessageKey(), ((InterceptorException) e).getArgs());
            }else{
                throw new InterceptorException("Interceptor : " + interceptor + StringUtils.SPACE + ExceptionUtils.getMessage(e));
            }
        }


    }

    public String getValidatorMessageWhenSave(Exception e) {
        String message = ExceptionUtils.getMessage(e);
        if (e instanceof TransactionSystemException
                && ((TransactionSystemException) e).getRootCause() instanceof ConstraintViolationException) {
            ConstraintViolationException modelValidatorEx =
                    ((ConstraintViolationException) ((TransactionSystemException) e).getRootCause());
            if (Objects.nonNull(modelValidatorEx)) {
                Set<ConstraintViolation<?>> constraintViolations = modelValidatorEx.getConstraintViolations();
                message = constraintViolations.iterator().hasNext()
                        ? constraintViolations.iterator().next().getMessage() : message;
            }
        } else if (e instanceof DataIntegrityViolationException) {
            message = ExceptionUtils.getRootCauseMessage(e);

        }
        return message;
    }
    enum Transaction {
        SAVE, REMOVE
    }
}
