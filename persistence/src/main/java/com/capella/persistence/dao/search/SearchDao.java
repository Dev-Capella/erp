package com.capella.persistence.dao.search;

import com.capella.domain.enums.SearchOperator;
import com.capella.domain.model.extend.ItemModel;

import java.util.Map;

public interface SearchDao {
    <T extends ItemModel> T searchSingleResult(Class<T> model, Map parameter, SearchOperator searchOperator);
}
