package com.misiontic.parking_ms.exceptions;

public class VehiculoNotFoundException extends RuntimeException{

    public VehiculoNotFoundException(String message) {
        super(message);
    }
}
