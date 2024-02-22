package com.capella.service.search.impl;

import com.capella.domain.enums.SearchOperator;
import com.capella.domain.model.extend.ItemModel;
import com.capella.persistence.dao.search.SearchDao;
import com.capella.service.exception.model.ModelNotFoundException;
import com.capella.service.search.SearchService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class SearchServiceImpl implements SearchService {

    protected final SearchDao searchDao;
    @Override
    public <T extends ItemModel> T searchSingleResult(Class<T> model, Map parameter, SearchOperator searchOperator) {
       try {
           return searchDao.searchSingleResult(model, parameter, searchOperator);
       }catch (NoResultException | EmptyResultDataAccessException e){
           throw new ModelNotFoundException(e.getMessage());
       }
    }
}
