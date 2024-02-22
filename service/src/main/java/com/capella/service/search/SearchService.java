package com.capella.service.search;

import com.capella.domain.enums.SearchOperator;
import com.capella.domain.model.extend.ItemModel;

import java.util.Map;

public interface SearchService {
    <T extends ItemModel> T searchSingleResult(Class<T> model, Map parameter, SearchOperator searchOperator);
}
