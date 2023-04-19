package com.prueba.alianza.infraestructure.restful.controllers;

import com.prueba.alianza.application.usescases.AddClient;
import com.prueba.alianza.infraestructure.restful.dto.request.EditClientDTO;
import com.prueba.alianza.infraestructure.restful.mappers.ClientDTOMapper;
import com.prueba.alianza.infraestructure.restful.mappers.EditClientDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddClientController extends BaseController{

    @Autowired
    private AddClient addClient;

    @PostMapping("client")
    public ResponseEntity<?> invoke(@RequestBody EditClientDTO editClientDTO) {
        try {
             return oKMessage(
                     ClientDTOMapper.INSTANCE.clientToClientDTO(addClient.execute(
                         EditClientDTOMapper.INSTANCE.EditClientDTOToClient(editClientDTO)
                     )));
        } catch (Exception ex) {
             return errorMessage(ex);
        }
    }

}
