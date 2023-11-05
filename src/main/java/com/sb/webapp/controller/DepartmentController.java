package com.sb.webapp.controller;


import com.sb.webapp.entity.Department;
import com.sb.webapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

//    private DepartmentController(DepartmentService departmentService){
//        this.departmentService = departmentService;
//    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PostMapping("/department")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department dep = departmentService.createDepartment(new Department(department.getId(), department.getName()));
        return new ResponseEntity<>(dep, HttpStatus.CREATED);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long id, @RequestBody Department department){
        Department dep = departmentService.updateDepartment(department, id);
        return new ResponseEntity<>(dep, HttpStatus.OK);
    }

}
