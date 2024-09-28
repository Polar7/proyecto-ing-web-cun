package com.ingweb.cun.infrastructure.exception;

public class BrandCarExistsException extends RuntimeException {

    public BrandCarExistsException() {
        super("La marca coche ingresada ya existe en la base de datos");
    }
}
