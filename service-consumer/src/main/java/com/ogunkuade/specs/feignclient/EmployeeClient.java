package com.ogunkuade.specs.feignclient;


import com.ogunkuade.specs.dto.EmployeeRequest;
import com.ogunkuade.specs.dto.EmployeeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

/*
    use "path" for internal API
    use "url" for external API
 */

@FeignClient(name = "EMPLOYEE-SERVICE", path = "/employee-app/api/employee")
public interface EmployeeClient {

    @PostMapping( "/create")
    EmployeeResponse savingEmployee(@RequestBody EmployeeRequest employeeRequest);

    @GetMapping("/{id}")
    EmployeeResponse gettingEmployeeById(@PathVariable Long id);

    @GetMapping("/all")
    List<EmployeeResponse> gettingAllEmployees();


}



