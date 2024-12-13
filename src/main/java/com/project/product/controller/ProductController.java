package com.project.product.controller;

import com.project.product.factory.ProductCatalogFactory;
import com.project.product.query.model.QueryParameter;
import com.project.product.resource.mapper.ProductRequestMapper;
import com.project.product.resource.model.GetProductResponse;
import com.project.product.resource.model.ProductRequest;
import com.project.product.resource.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductCatalogFactory productCatalogFactory;

    @PostMapping("/addproducts")
    public ResponseEntity<ProductResponse> createProduct(
            //@RequestHeader("sellerId") String sellerId,
            @Validated @RequestBody ProductRequest productRequest) {

        //log.info("Creating product, name {}", productRequest.getProductName());

        var product = ProductRequestMapper.MAPPER.map(productRequest);
        var productCatalogCommand = productCatalogFactory.getProductCatalogCommand();

        var productId = productCatalogCommand.addProduct(product);

        var productResponse = new ProductResponse(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<GetProductResponse>> listProducts(
            @RequestHeader("sellerId") String sellerId, @RequestParam String status) {

        //log.info("Getting all products");

        var productCatalogQuery = productCatalogFactory.getProductQuery();

        var queryParameter = new QueryParameter();
        queryParameter.setStatus(status);

        var products = productCatalogQuery.getProducts(queryParameter);

        var productResponse =
                products.stream().map(ProductRequestMapper.MAPPER::map).collect(Collectors.toList());

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProductById(
            @RequestHeader("sellerId") String sellerId, @PathVariable @NonNull Long productId) {

       // log.info("Getting product, id {}", productId);

        var productCatalogQuery = productCatalogFactory.getProductQuery();

        var product = productCatalogQuery.getProduct(productId);

        var productResponse = ProductRequestMapper.MAPPER.map(product);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
