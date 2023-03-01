package com.ecommerce.ECommerce.Service;

import com.ecommerce.ECommerce.Entity.Department;
import com.ecommerce.ECommerce.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        List<Department> Departments = new ArrayList<>();
        departmentRepository.findAll().forEach(Departments::add);
        return Departments;
    }

    public void addDepartment(Department Department) {
        departmentRepository.save(Department);
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    public Department getDepartmentByAddress(String departmentAddress) {
        return departmentRepository.findByDepartmentAddress(departmentAddress);
    }

    public Department getDepartmentByCode(String departmentCode) {
        return departmentRepository.findByDepartmentCode(departmentCode);
    }

    public void updateDepartment(Long id, Department Department) {
        departmentRepository.findById(id)
                .map(Department1 -> {
                    Department1.setDepartmentName(Department.getDepartmentName());
                    Department1.setDepartmentAddress(Department.getDepartmentAddress());
                    Department1.setDepartmentCode(Department.getDepartmentCode());
                    return departmentRepository.save(Department1);
                })
                .orElseGet(
                        () -> {
                            return departmentRepository.save(Department);
                        }
                );
    }

    public void removeDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
