package com.project.product.resource.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductRequest {
    private Long productId;

    @NotNull(message = "Product name is required.")
    @NotBlank(message = "Product name cannot be blank.")
    private String productName;

    private String description;

    @NotNull(message = "Price is required.")
    @NotBlank(message = "Price cannot be blank.")
    private String price;

    @NotNull(message = "Model is required.")
    @NotBlank(message = "Model cannot be blank.")
    private String model;

    private String brand;
}
