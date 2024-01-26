package com.capella.persistence.dao.product;

import com.capella.domain.model.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<ProductModel, Long> {

    ProductModel getByCode(String code);

    List<ProductModel> findAll();
}
