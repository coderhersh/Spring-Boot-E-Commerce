package com.ecommerce.ECommerce.Repository;

import com.ecommerce.ECommerce.Entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findByDepartmentName(String departmentName);
    Department findByDepartmentAddress(String departmentAddress);
    Department findByDepartmentCode(String departmentCode);
}
