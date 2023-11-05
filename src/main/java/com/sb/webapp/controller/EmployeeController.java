package com.sb.webapp.controller;

import com.sb.webapp.entity.Department;
import com.sb.webapp.entity.Employee;
import com.sb.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("departments/{departmentId}/employees")
    public ResponseEntity<List<Employee>> getAllEmployeesByDepartment(@PathVariable("departmentId") Long dep_id){
        List<Employee> employees = employeeService.getAllEmployeesByDepartment(dep_id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("departments/{departmentId}/employees")
    public ResponseEntity<Employee> createEmployee(@PathVariable("departmentId") Long dep_id, @RequestBody Employee employee){
        Employee emp = employeeService.createEmployee(dep_id, employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        Employee emp = employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employee/afm/{afm}")
    public ResponseEntity<Employee> getEmployeeByAfm(@PathVariable("afm") String afm){
        Employee employee =  employeeService.getEmployeeByAfm(afm);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
