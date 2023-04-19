package com.prueba.alianza.application.usescases;

import com.prueba.alianza.application.repositories.ClientRepository;
import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.domain.models.Paging;


public class SearchBySharedKey {

    private final ClientRepository clientRepository;

    public SearchBySharedKey(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Paging<Client> execute(String sharedKey, int currentPage, int size) {
        return clientRepository.searchBySharedKey(sharedKey,currentPage,size);
    }

}
