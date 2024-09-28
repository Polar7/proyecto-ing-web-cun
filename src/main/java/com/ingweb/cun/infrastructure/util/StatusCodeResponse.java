package com.ingweb.cun.infrastructure.util;

/**
 * Coleccion de constantes para respuestas de los controladores
 */
public enum StatusCodeResponse {
    OK(0, "Exitoso"), ERROR_FUNCTIONAL(55, "Error de validaciones"), ERROR_SERVER(99, "Error no controlado");

    private final Integer valueCode;

    private final String messageStatus;

    StatusCodeResponse(int value, String message) {
        this.valueCode = value;
        this.messageStatus = message;
    }

    public int getValueCode() {
        return valueCode;
    }

    public String getMessageStatus() {
        return messageStatus;
    }
}
