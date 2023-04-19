package com.prueba.alianza.infraestructure.restful.controllers;

import com.prueba.alianza.application.usescases.SearchBySharedKey;
import com.prueba.alianza.infraestructure.restful.mappers.PagingClientDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchBySharedKeyController extends BaseController{

    @Autowired
    private SearchBySharedKey searchBySharedKey;

    @GetMapping("clients/sharedKey")
    public ResponseEntity<?> invoke(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "3") int size,
                                    @RequestParam String sharedkey) {
        try {
            return oKMessage(PagingClientDTOMapper.INSTANCE.pagingToPagingDTO(searchBySharedKey.execute(sharedkey,page,size)));
        } catch (Exception ex) {
            return errorMessage(ex);
        }

    }
}
