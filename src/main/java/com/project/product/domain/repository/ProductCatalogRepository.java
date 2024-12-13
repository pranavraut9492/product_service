package com.project.product.domain.repository;

import com.project.product.domain.Product;
import com.project.product.query.model.QueryParameter;

import java.util.List;

public interface ProductCatalogRepository {

    Long save(Product product);

    Product get(Long productId);

    List<Product> getAll(QueryParameter queryParameter);

    void delete(Long productId);
}
