package com.capella.facade.product;

import com.capella.domain.data.product.ProductData;

import java.util.Set;

public interface ProductFacade {
    void save(ProductData productData);
    Set<ProductData> getAll();
    ProductData get(String code);
    void delete(String code);
}
