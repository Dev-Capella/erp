package com.capella.persistence.dao.search.impl;

import com.capella.domain.enums.SearchOperator;
import com.capella.domain.model.extend.ItemModel;
import com.capella.persistence.dao.search.SearchDao;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
@Slf4j
@Transactional
public class SearchDaoImpl implements SearchDao {

    @PersistenceContext
    protected EntityManager entityManager;
    @Override
    public <T extends ItemModel> T searchSingleResult(Class<T> model, Map parameter, SearchOperator searchOperator) {

        Query query = createQuery(model, parameter, searchOperator);
        try{
            return (T) query.getSingleResult();
        }catch (NoResultException e){
            throw new NoResultException(ExceptionUtils.getMessage(e) + " Parameter : {" + parameter.toString() + "}");
        }
    }

    private Query createQuery(Class itemClass, Map parameter, SearchOperator searchOperator){

        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT m from ").append(itemClass.getSimpleName()).append(" m ");

        var nullFields = new HashMap<>();
        if(MapUtils.isNotEmpty(parameter)){
            parameter.keySet().forEach(e -> {
                if(Objects.isNull(parameter.get(e))){
                    nullFields.put(e, parameter.get(e));
                }
            });

            if(MapUtils.isNotEmpty(nullFields)){
                nullFields.forEach((key,value) -> {
                    parameter.remove(key,nullFields.get(key));
                });
            }
        }

        if(MapUtils.isNotEmpty(parameter)){
            queryBuilder.append("WHERE ");
            parameter.keySet().forEach(e -> queryBuilder.append(e).append("=").append(":" + e).append(StringUtils.SPACE)
                    .append(searchOperator.getValue()).append(StringUtils.SPACE));
            queryBuilder.replace(queryBuilder.length() - StringUtils.length(searchOperator.getValue()) - 1, queryBuilder.length(),StringUtils.EMPTY);
        }

        if(MapUtils.isNotEmpty(nullFields)){
            nullFields.keySet().forEach(p -> queryBuilder.append(searchOperator.getValue()).append(StringUtils.SPACE)
                    .append(p).append(StringUtils.SPACE).append(" is null"));
        }

        TypedQuery<? extends ItemModel> query = entityManager.createQuery(queryBuilder.toString(), itemClass);

        if(!parameter.isEmpty()){
            parameter.keySet().forEach(e -> query.setParameter(e.toString(), parameter.get(e)));
        }

        return query;
    }
}
