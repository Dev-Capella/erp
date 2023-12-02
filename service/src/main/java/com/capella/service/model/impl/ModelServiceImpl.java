package com.capella.service.model.impl;

import com.capella.domain.model.extend.ItemModel;
import com.capella.persistence.dao.model.ModelDao;
import com.capella.service.model.ModelService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Transactional
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    protected final ModelDao modelDao;

    @Override
    public <T extends ItemModel> T save(T t) {
        try {
            var model = modelDao.save(t);
            return model;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public <T extends ItemModel> Iterable<T> saveAll(Iterable<T> t) {
        try {
            var models = modelDao.saveAll(t);
            return models;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public <T extends ItemModel> Iterable<T> saveAll(T... t) {
        try {
            var models = modelDao.saveAll(Arrays.asList(t));
            return models;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public <T extends ItemModel> void remove(T t) {
        try {
            modelDao.delete(t);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public <T extends ItemModel> void removeAll(Iterable<T> t) {
        try {
            modelDao.deleteAll(t);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public <T extends ItemModel> void removeAll(T... t) {
        try {
            var list = Arrays.asList(t);
            modelDao.deleteAll(list);
        } catch (Exception e) {
            throw e;
        }

    }
}
