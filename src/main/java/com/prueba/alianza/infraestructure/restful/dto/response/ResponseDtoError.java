package com.prueba.alianza.infraestructure.restful.dto.response;

public class ResponseDtoError extends ResponseDTO {
    public ResponseDTO message(String error) {
        setError(error);
        setMessage("ERROR");
        setResult(null);
        return this;
    }
}