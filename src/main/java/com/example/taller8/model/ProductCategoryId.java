package com.example.taller8.model;

import lombok.Getter;
import jakarta.persistence.*;
import java.io.Serializable;


@Embeddable
@Getter
public class ProductCategoryId implements Serializable {

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "category_id")
    private Long categoryId;
}
