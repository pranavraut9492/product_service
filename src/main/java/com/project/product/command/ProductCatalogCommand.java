package com.project.product.command;

import com.project.product.domain.Product;

public interface ProductCatalogCommand {

    Long addProduct(Product product);

    void deleteProduct(Long productId);

    void publish(Long productId);

    Long  updateProduct(Product product);
}
