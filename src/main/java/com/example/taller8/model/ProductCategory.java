package com.example.taller8.model;

import jakarta.persistence.*;
import lombok.Getter;


@Table(name = "product_category")
@Entity(name = "ProductCategory")
@Getter
public class ProductCategory {

    @EmbeddedId
    private ProductCategoryId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(
            name = "product_id",
            foreignKey = @ForeignKey(
                    name = "product_category_product_id_fk"
            )
    )
    private Product product;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(
            name = "category_id",
            foreignKey = @ForeignKey(
                    name = "product_category_category_id_fk"
            )
    )
    private Category category;
}
