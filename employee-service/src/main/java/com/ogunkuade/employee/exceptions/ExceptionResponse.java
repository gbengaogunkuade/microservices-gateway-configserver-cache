package com.ogunkuade.employee.exceptions;

import java.util.Date;

public record ExceptionResponse (Date timestamp, String subject, String message){
    //
}


