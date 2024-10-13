package com.example.taller8.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Table(name = "category")
@Entity(name = "Category")
@NoArgsConstructor
@Getter
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;
}

