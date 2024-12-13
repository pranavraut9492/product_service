package com.project.product.command;

import com.project.product.domain.Product;
import com.project.product.domain.ProductCatalog;
import com.project.product.domain.repository.ProductCatalogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductCatalogCommandImpl implements ProductCatalogCommand {

    private final ProductCatalogRepository productCatalogRepository;

    @Override
    public Long addProduct(Product product) {
        var productCatalog = new ProductCatalog(productCatalogRepository);
        return productCatalog.addProduct(product);
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public void publish(Long productId) {

    }

    @Override
    public Long updateProduct(Product product) {
        return 0L;
    }

    /*@Override
    public void deleteProduct(Long productId) {
        var productCatalog = new ProductCatalog(productCatalogRepository);
        productCatalog.deleteProduct(productId);
    }*/

    /*@Override
    public void publish(Long productId) {
        var productCatalog = new ProductCatalog(productCatalogRepository);
        productCatalog.publish(productId);

    }

    @Override
    public Long updateProduct(Product product) {
        var productCatalog = new ProductCatalog(productCatalogRepository);
        return productCatalog.updateProduct(product);
    }*/
}
