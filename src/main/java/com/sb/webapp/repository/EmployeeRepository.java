package com.sb.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sb.webapp.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long dep_id);
    Employee findByAfm(String afm);
    //Employee findByFirstNameAndOrLastName(String firstName, String lastName);
}
