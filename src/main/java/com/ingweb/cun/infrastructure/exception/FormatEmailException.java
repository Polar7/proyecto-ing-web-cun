package com.ingweb.cun.infrastructure.exception;

/**
 * Excepcion que se va a lanzar cuando un email no tiene el formato adecuado
 */
public class FormatEmailException extends RuntimeException {

    public FormatEmailException() {
        super("Error con el formato del correo");
    }
}
