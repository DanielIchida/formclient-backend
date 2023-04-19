package com.prueba.alianza.application.usescases;

import com.prueba.alianza.application.repositories.ClientRepository;
import com.prueba.alianza.domain.models.Client;

public class AddClient {

    private final ClientRepository clientRepository;

    public AddClient(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client execute(Client client) {
        return clientRepository.add(client);
    }
}
