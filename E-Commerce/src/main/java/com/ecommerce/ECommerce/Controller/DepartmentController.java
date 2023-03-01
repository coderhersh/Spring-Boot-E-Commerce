package com.ecommerce.ECommerce.Controller;

import com.ecommerce.ECommerce.Entity.Department;
import com.ecommerce.ECommerce.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController(value = "")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/get-records")
    public List<Department> getRecords() {
        return departmentService.getDepartments();
    }

    @GetMapping(value = "get-record/id/{id}")
    public Optional<Department> getRecordById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping(value = "get-record/name/{name}")
    public Department getRecordByName(@PathVariable String name) {
        return departmentService.getDepartmentByName(name);
    }

    @GetMapping(value = "get-record/address/{address}")
    public Department getRecordByAddress(@PathVariable String address) {
        return departmentService.getDepartmentByName(address);
    }

    @GetMapping(value = "get-record/code/{code}")
    public Department getRecordByCode(@PathVariable String code) {
        return departmentService.getDepartmentByName(code);
    }

    @PostMapping(value = "add-record")
    public void addRecord(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }

    @PutMapping(value = "update-record/{id}")
    public void updateRecord(@RequestBody Department department, @PathVariable Long id) {
        departmentService.updateDepartment(id, department);
    }

    @DeleteMapping(value = "remove-record/{id}")
    public void removeRecord(@PathVariable Long id) {
        departmentService.removeDepartment(id);
    }

}
