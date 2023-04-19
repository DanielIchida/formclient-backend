package com.prueba.alianza.application.usescases;

import com.prueba.alianza.application.repositories.ClientRepository;
import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.domain.models.Paging;
import io.micrometer.common.util.StringUtils;


public class SearchAdvanced {

    private final ClientRepository clientRepository;

    public SearchAdvanced(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Paging<Client> execute(String name,String phone,String email, String startDate,String endDate, int currentPage, int size) {
        if(StringUtils.isBlank(name) && StringUtils.isBlank(phone) &&
                StringUtils.isBlank(email) && StringUtils.isBlank(endDate) &&
                StringUtils.isBlank(endDate)) {
             return clientRepository.findAll(currentPage,size);
        }
        return clientRepository.searchAdvanced(name,phone,email,startDate,endDate,currentPage,size);
    }

}
