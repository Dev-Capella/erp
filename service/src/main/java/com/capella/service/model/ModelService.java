package com.capella.service.model;

import com.capella.domain.model.extend.ItemModel;

public interface ModelService {
    <T extends ItemModel> T save(T t);
    <T extends ItemModel> Iterable<T> saveAll(Iterable<T> var1);
    <T extends ItemModel> Iterable<T> saveAll(T... t);
    <T extends ItemModel> void remove(T t);
    <T extends ItemModel> void removeAll(Iterable<T> var1);
    <T extends ItemModel> void removeAll(T... t);
    <T extends ItemModel> T create(Class<T> tClass);

}
