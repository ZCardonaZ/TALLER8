package com.example.taller8.model;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;
import java.util.List;


@Table(name = "order_table")
@Entity(name = "Order")
@NoArgsConstructor
@Getter
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column
    private Long id;

    @Column(
            nullable = false
    )
    private int totalPrice;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "order_customer_fk"
            )
    )
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(
            orphanRemoval = true,
            mappedBy = "order",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<OrderItem> orderItems;
}

