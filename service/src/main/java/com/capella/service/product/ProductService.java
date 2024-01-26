package com.capella.service.product;

import com.capella.domain.model.product.ProductModel;

import java.util.Set;

public interface ProductService {
    ProductModel getProductModel(String code);
    Set<ProductModel> getProductModels();
}
