package com.project.product.persistence;

import com.project.product.domain.Product;
import com.project.product.domain.repository.ProductCatalogRepository;
import com.project.product.persistence.jpa.ProductCatalogJpaRepository;
import com.project.product.persistence.mapper.ProductPersistableMapper;
import com.project.product.persistence.model.ProductPersistable;
import com.project.product.query.model.QueryParameter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductCatalogRepositoryImpl implements ProductCatalogRepository {

    private final ProductCatalogJpaRepository productCatalogJpaRepository;

    public ProductCatalogRepositoryImpl(ProductCatalogJpaRepository productCatalogJpaRepository) {
        this.productCatalogJpaRepository = productCatalogJpaRepository;
    }

    @Override
    public Long save(Product product) {
        var entity = ProductPersistableMapper.MAPPER.map(product);
        entity = productCatalogJpaRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Product get(Long productId) {
        Optional<ProductPersistable> productPersistable =
                productCatalogJpaRepository.findById(productId);
        return productPersistable
                .map(ProductPersistableMapper.MAPPER::map)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
    }

    @Override
    public List<Product> getAll(QueryParameter queryParameter) {
        var productPersistables = productCatalogJpaRepository.findAll(queryParameter.getStatus());
        return productPersistables.stream()
                .map(ProductPersistableMapper.MAPPER::map)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long productId) {
        productCatalogJpaRepository.deleteById(productId);
    }
}
