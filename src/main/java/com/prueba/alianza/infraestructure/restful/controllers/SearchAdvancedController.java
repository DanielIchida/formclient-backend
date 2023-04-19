package com.prueba.alianza.infraestructure.restful.controllers;

import com.prueba.alianza.application.usescases.SearchAdvanced;
import com.prueba.alianza.application.usescases.SearchBySharedKey;
import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.domain.services.ClientService;
import com.prueba.alianza.infraestructure.restful.dto.response.ClientDTO;
import com.prueba.alianza.infraestructure.restful.mappers.ClientDTOMapper;
import com.prueba.alianza.infraestructure.restful.mappers.PagingClientDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class SearchAdvancedController extends BaseController{

    @Autowired
    public SearchAdvanced searchAdvanced;

    @GetMapping("clients/filter")
    public ResponseEntity<?> invoke(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "3") int size,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String phone,
                                    @RequestParam(required = false)  String email,
                                    @RequestParam(required = false) String startDate,
                                    @RequestParam(required = false) String endDate) {
        return oKMessage(PagingClientDTOMapper.INSTANCE.pagingToPagingDTO(searchAdvanced.execute(name,phone,email,startDate,endDate,page,size)));

    }

}
