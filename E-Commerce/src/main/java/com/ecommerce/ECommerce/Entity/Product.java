package com.ecommerce.ECommerce.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long Id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "price")
    Float price;

    @Column(name = "image")
    String image;

    @Column(name = "created_timestamp")
    LocalDate createdTimeStamp;

    @Column(name = "modified_timestamp")
    LocalDate modifiedTimeStamp;
}
