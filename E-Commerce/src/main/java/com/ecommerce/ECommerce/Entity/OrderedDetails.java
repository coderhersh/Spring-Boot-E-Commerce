package com.ecommerce.ECommerce.Entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "ordered_details")
@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderedDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderedDetailsId;

    @Column(name = "bill")
    private Float bill;
}
