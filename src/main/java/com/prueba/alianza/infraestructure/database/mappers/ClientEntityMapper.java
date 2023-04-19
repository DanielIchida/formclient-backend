package com.prueba.alianza.infraestructure.database.mappers;

import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.domain.services.ClientService;
import com.prueba.alianza.infraestructure.database.entities.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientEntityMapper {

    ClientEntityMapper INSTANCE = Mappers.getMapper(ClientEntityMapper.class);

    default ClientEntity clientEntityToClient(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(client.getId());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setName(client.getBusinessId());
        clientEntity.setPhone(client.getPhone());
        clientEntity.setEndDate(client.getEndDate());
        clientEntity.setStartDate(client.getStartDate());
        return clientEntity;
    }

    default Client clientToClientEntity(ClientEntity clientEntity) {
        Client client = new Client();
        client.setId(clientEntity.getId());
        client.setBusinessId(clientEntity.getName());
        client.setPhone(clientEntity.getPhone());
        client.setSharedKey(ClientService.getSharedKey(clientEntity.getEmail()));
        client.setEndDate(clientEntity.getEndDate());
        client.setStartDate(clientEntity.getStartDate());
        client.setEmail(clientEntity.getEmail());
        return client;
    }

}
