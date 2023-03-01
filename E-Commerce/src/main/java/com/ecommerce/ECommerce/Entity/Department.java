package com.ecommerce.ECommerce.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Table
@Entity(name = "department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    @Column(name = "departmentName")
    private String departmentName;
    @Column(name = "departmentAddress")
    private String departmentAddress;
    @Column(name = "departmentCode")
    private String departmentCode;
}
