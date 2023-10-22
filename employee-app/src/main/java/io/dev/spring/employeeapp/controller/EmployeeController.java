package io.dev.spring.employeeapp.controller;

import io.dev.spring.employeeapp.model.Employee;
import io.dev.spring.employeeapp.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/employees")
    public List<Employee> getEmployees(){
        List<Employee> employees = employeeService.getEmployees();
        return employees;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
    public Employee getEmployee(@PathVariable long id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable long id){
        employeeService.updateEmployee(employee, id);
    }
}
