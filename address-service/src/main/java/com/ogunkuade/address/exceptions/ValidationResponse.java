package com.ogunkuade.address.exceptions;

import java.util.Date;
import java.util.List;

public record ValidationResponse(Date date, String subject, List<String> errorList) {
    //
}
