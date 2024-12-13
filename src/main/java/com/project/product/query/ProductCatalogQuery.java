package com.project.product.query;

import com.project.product.domain.Product;
import com.project.product.query.model.QueryParameter;

import java.util.List;

public interface ProductCatalogQuery {

    Product getProduct(Long productId);
    List<Product> getProducts(QueryParameter queryParameter);
}
