package com.sb.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sb.webapp.entity.Department;
import java.util.List;
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //List<Department> findByName(String name);
}
