package com.ogunkuade.employee.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    public EmployeeNotFoundException(String message){
        super(message);
    }


}


