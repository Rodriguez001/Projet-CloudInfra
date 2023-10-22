package io.dev.spring.employeeapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.dev.spring.employeeapp.model.Employee;
import io.dev.spring.employeeapp.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
            employees.add(employee);
        });
        return employees;
    }

    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).orElse(null);
        //return EmployeeList.stream().filter(Employee -> Employee.getId() == id).findFirst().orElse(null);
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
        //EmployeeList.removeIf(Employee -> Employee.getId() == id);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
        //EmployeeList.add(Employee);
    }

    public void updateEmployee(Employee employee, long id) {
        employeeRepository.save(employee);
        // EmployeeList.forEach(Employee1 -> {
        //     if (Employee1.getId() == id){
        //         EmployeeList.set(EmployeeList.indexOf(Employee1), Employee);
        //     }
        // });
    }

}
