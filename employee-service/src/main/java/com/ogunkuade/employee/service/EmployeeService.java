package com.ogunkuade.employee.service;


import com.ogunkuade.employee.dto.EmployeeRequest;
import com.ogunkuade.employee.entity.Employee;
import com.ogunkuade.employee.exceptions.EmployeeNotFoundException;
import com.ogunkuade.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {


    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    //CREATE NEW EMPLOYEE
    public Employee saveEmployee(EmployeeRequest employeeRequest){
        Employee employeeNew = new Employee(
                employeeRequest.getName(),
                employeeRequest.getEmail(),
                employeeRequest.getBloodGroup()
        );
        Employee employee = employeeRepository.save(employeeNew);
        return employee;
    }


    //GET EMPLOYEE BY ID
    @Cacheable(cacheNames = "employees", key = "#id")   //CACHING
    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee with this Id not found"));
        logger.info(String.format("EMPLOYEE FETCH FROM DATABASE"));
        return employee;
    }


    //GET ALL EMPLOYEES
    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }


    //DELETE EMPLOYEE BY ID
    @CacheEvict(cacheNames = "employees", key = "#id")
    public String deleteEmployeeById(Long id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee with this Id not found"));
        employeeRepository.delete(employee);
        logger.info(String.format("EMPLOYEE DELETED FROM DATABASE"));
        return String.format("employee with this id %d has been deleted", id);
    }




}
