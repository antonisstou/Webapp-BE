package com.sb.webapp.service;

import com.sb.webapp.entity.Department;
import com.sb.webapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public void deleteDepartmentById(Long id){
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(Department department, Long id){
        Department dep = departmentRepository.findById(id).get();
        dep.setName(department.getName());
        return departmentRepository.save(dep);
    }

}
