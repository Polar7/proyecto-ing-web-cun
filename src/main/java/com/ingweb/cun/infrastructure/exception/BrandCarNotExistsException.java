package com.ingweb.cun.infrastructure.exception;

public class BrandCarNotExistsException extends RuntimeException {

    public BrandCarNotExistsException() {
        super("La marca coche ingresada NO existe en la base de datos");
    }
}
