package com.project.product.factory;

import com.project.product.command.ProductCatalogCommand;
import com.project.product.query.ProductCatalogQuery;
import org.springframework.stereotype.Component;

@Component
public class ProductCatalogFactoryImpl implements ProductCatalogFactory{
    private final ProductCatalogCommand productCatalogCommand;
    private final ProductCatalogQuery productCatalogQuery;

    public ProductCatalogFactoryImpl(
            ProductCatalogCommand productCatalogCommand, ProductCatalogQuery productCatalogQuery) {
        this.productCatalogCommand = productCatalogCommand;
        this.productCatalogQuery = productCatalogQuery;
    }

    @Override
    public ProductCatalogCommand getProductCatalogCommand() {
        return productCatalogCommand;
    }

    @Override
    public ProductCatalogQuery getProductQuery() {
        return productCatalogQuery;
    }
}
