package com.ecommerce.ECommerce.Entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "ordered_products")
@Table
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderedProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderedProductId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Float price;

    @Column(name = "discount")
    private Float discount;

    @Column(name = "total")
    private Float total;
}
