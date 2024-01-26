package com.capella.service.product.impl;

import com.capella.domain.model.product.ProductModel;
import com.capella.persistence.dao.product.ProductDao;
import com.capella.service.product.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Override
    public ProductModel getProductModel(String code) {
        var productModel = productDao.getByCode(code);
        return productModel;
    }

    @Override
    public Set<ProductModel> getProductModels() {
        List<ProductModel> productModels = productDao.findAll();
        Set<ProductModel> productModelSet = new HashSet<>(productModels);
        return productModelSet;
    }
}
