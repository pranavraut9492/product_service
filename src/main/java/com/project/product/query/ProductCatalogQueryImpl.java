package com.project.product.query;

import com.project.product.domain.Product;
import com.project.product.query.model.QueryParameter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCatalogQueryImpl implements ProductCatalogQuery{
    @Override
    public Product getProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getProducts(QueryParameter queryParameter) {
        return List.of();
    }
}
