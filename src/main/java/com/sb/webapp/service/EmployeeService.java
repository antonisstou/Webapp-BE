package com.sb.webapp.service;

import com.sb.webapp.entity.Department;
import com.sb.webapp.entity.Employee;
import com.sb.webapp.repository.DepartmentRepository;
import com.sb.webapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployeesByDepartment(Long id){
        return employeeRepository.findByDepartmentId(id);
    }

    public Employee createEmployee(Long dep_id, Employee employee){

        Department department = departmentRepository.findById(dep_id).orElseThrow(() -> new RuntimeException("Department id not found - " + dep_id));
        //if (department.getId() == employee.getDepartment().getId()){
        return employeeRepository.save(employee);
        //}
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee is not found - " + id));
    }

    public Employee updateEmployee(Employee employee, Long id){
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee is not found - " + id));
        emp.setAfm(employee.getAfm());
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setDepartment(employee.getDepartment());
        emp.setBirthday(employee.getBirthday());
        return employeeRepository.save(emp);
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeByAfm(String afm){
        return employeeRepository.findByAfm(afm);
    }

}
