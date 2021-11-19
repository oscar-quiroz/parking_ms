package com.misiontic.parking_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class VehiculoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(VehiculoNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String VehiculoNotFound(TransactionNotFoundException ex){
        return ex.getMessage();
    }


}
