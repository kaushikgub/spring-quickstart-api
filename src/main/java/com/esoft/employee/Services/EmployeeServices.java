package com.esoft.employee.Services;

import com.esoft.employee.Exceptions.UserNotFoundException;
import com.esoft.employee.Repositories.EmployeeRepository;
import com.esoft.employee.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        employee.setCreatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee get(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}
