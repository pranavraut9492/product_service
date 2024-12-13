package com.project.product.resource.mapper;
import com.project.product.domain.Product;
import com.project.product.resource.model.GetProductResponse;
import com.project.product.resource.model.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductRequestMapper {

    public static final ProductRequestMapper MAPPER = Mappers.getMapper(ProductRequestMapper.class);

    public abstract Product map(ProductRequest request);

    public abstract GetProductResponse map(Product product);
}
