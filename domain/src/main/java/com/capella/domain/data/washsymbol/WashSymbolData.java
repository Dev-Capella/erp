package com.capella.domain.data.washsymbol;

import com.capella.domain.data.base.BaseDescriptionData;
import com.capella.domain.data.washsymbolcategory.WashSymbolCategoryData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class WashSymbolData extends BaseDescriptionData {
    private WashSymbolCategoryData washSymbolCategory;
}
