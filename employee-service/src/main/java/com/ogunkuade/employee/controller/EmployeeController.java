package com.ogunkuade.employee.controller;

import com.ogunkuade.employee.dto.EmployeeRequest;
import com.ogunkuade.employee.entity.Employee;
import com.ogunkuade.employee.exceptions.EmployeeNotFoundException;
import com.ogunkuade.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //CREATE NEW EMPLOYEE
    @PostMapping("/create")
    public Employee savingEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.saveEmployee(employeeRequest);
    }

    //GET EMPLOYEE BY ID
    @GetMapping("/{id}")
    public Employee gettingEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        System.out.println("Getting Employee By Id");
        return employeeService.getEmployeeById(id);
    }

    //GET ALL EMPLOYEES
    @GetMapping("/all")
    public List<Employee> getttingAllEmployees(){
        System.out.println("Getting All Employees");
        return employeeService.getAllEmployees();
    }


    //DELETE EMPLOYEE BY ID
    @DeleteMapping(path = "/{id}/delete")
    public String deleteEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.deleteEmployeeById(id);
    }



}
