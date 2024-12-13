package com.project.product.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table( name = "product")
public class ProductPersistable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productStatus;
    private String productName;
    private String description;
    private String price;
    private String model;
    private String brand;
}
