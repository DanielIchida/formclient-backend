package com.prueba.alianza.application.usescases;

import com.prueba.alianza.application.repositories.ClientRepository;
import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.domain.models.Paging;

import java.util.List;

public class FindAll {

    private final ClientRepository clientRepository;

    public FindAll(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Paging<Client> execute(int currentPage, int size) {
        return clientRepository.findAll(currentPage,size);
    }

}
