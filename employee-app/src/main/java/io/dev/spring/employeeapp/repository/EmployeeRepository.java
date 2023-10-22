package io.dev.spring.employeeapp.repository;

import org.springframework.data.repository.CrudRepository;

import io.dev.spring.employeeapp.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{    
}
