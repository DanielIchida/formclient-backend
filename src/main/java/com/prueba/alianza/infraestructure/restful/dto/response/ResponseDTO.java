package com.prueba.alianza.infraestructure.restful.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    private String message;
    private String error;
    private Object result;

}
