package com.prueba.alianza.infraestructure.restful.controllers;

import com.prueba.alianza.infraestructure.restful.dto.response.ResponseDtoError;
import com.prueba.alianza.infraestructure.restful.dto.response.ResponseDtoOk;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public abstract class BaseController {

    public ResponseEntity errorMessage(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDtoError().message(e.getMessage()));
    }

    public ResponseEntity oKMessage(Object data) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDtoOk().message(data));
    }


}
