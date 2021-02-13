package com.esoft.employee.Repositories;

import com.esoft.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteById(Long id);
}
