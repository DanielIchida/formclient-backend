package com.prueba.alianza.infraestructure.restful.controllers;


import com.prueba.alianza.application.usescases.FindAll;
import com.prueba.alianza.infraestructure.restful.mappers.PagingClientDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindAllController extends BaseController {

    @Autowired
    public FindAll findAll;

    @GetMapping("clients")
    public ResponseEntity<?> invoke(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "3") int size) {
        try {
            return oKMessage(PagingClientDTOMapper.INSTANCE.pagingToPagingDTO(findAll.execute(page,size)));
        } catch (Exception ex) {
            return errorMessage(ex);
        }

    }

}
