package com.ecommerce.ECommerce.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long customerId;

    @Column(name = "name")
    String name;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "address")
    String Address;

    @Column(name = "date_of_birth")
    LocalDate dateOfBirth;

    @Column(name = "age")
    Integer age;

    @Column(name = "created_timestamp")
    LocalDate createdTimeStamp;

    @Column(name = "modified_timestamp")
    LocalDate modifiedTimeStamp;
}
