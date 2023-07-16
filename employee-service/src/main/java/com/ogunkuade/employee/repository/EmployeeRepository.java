package com.ogunkuade.employee.repository;


import com.ogunkuade.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeesById(Long id);
    Employee findEmployeesByName(String name);
    Boolean existsByName(Long id);


}
