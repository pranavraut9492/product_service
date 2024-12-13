package com.project.product.factory;

import com.project.product.command.ProductCatalogCommand;
import com.project.product.query.ProductCatalogQuery;

public interface ProductCatalogFactory {

    ProductCatalogCommand getProductCatalogCommand();

    /**
     * returns product catalog query
     *
     * @return query
     */
    ProductCatalogQuery getProductQuery();
}
