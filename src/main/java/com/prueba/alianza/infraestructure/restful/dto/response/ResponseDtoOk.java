package com.prueba.alianza.infraestructure.restful.dto.response;

public class ResponseDtoOk extends ResponseDTO {
    public ResponseDTO message(Object result) {
        setError("");
        setMessage("OK");
        setResult(result);
        return this;
    }
}