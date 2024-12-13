package com.project.product.domain;

import com.project.product.domain.repository.ProductCatalogRepository;
import com.project.product.query.model.QueryParameter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductCatalog {

    private final ProductCatalogRepository productCatalogRepository;

    /*public ProductCatalog(ProductCatalogRepository productCatalogRepository) {
        this.productCatalogRepository = productCatalogRepository;
    }*/

    public Long addProduct(Product product) {
        // Add business validation
        product.setProductStatus(ProductStatus.DRAFT.name());
        return productCatalogRepository.save(product);
    }

    public Long updateProduct(Product product) throws IllegalAccessException {
        var productStatus = product.getProductStatus();
        if (productStatus != null && productStatus.equalsIgnoreCase(ProductStatus.PUBLISHED.name())) {
            throw new IllegalAccessException("Product status cannot be changed");
        }
        product.setProductStatus(ProductStatus.DRAFT.name());
        return productCatalogRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productCatalogRepository.delete(productId);
    }

    public List<Product> getAll(QueryParameter queryParameter) {
        return productCatalogRepository.getAll(queryParameter);
    }

    public Product get(Long productId) {
        return productCatalogRepository.get(productId);
    }

    public void publish(Long productId) throws IllegalAccessException {
        var product = productCatalogRepository.get(productId);
        if (!product.getProductStatus().equalsIgnoreCase(ProductStatus.DRAFT.name())) {
            throw new IllegalAccessException("Only DRAFT product can be published");
        }
        product.setProductStatus(ProductStatus.PUBLISHED.name());
        productCatalogRepository.save(product);
    }
}
