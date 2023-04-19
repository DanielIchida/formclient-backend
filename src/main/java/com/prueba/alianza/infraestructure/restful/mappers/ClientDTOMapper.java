package com.prueba.alianza.infraestructure.restful.mappers;

import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.infraestructure.restful.dto.response.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientDTOMapper {

    ClientDTOMapper INSTANCE = Mappers.getMapper(ClientDTOMapper.class);

    ClientDTO clientToClientDTO(Client client);
    Client clientDTOToClient(ClientDTO clientDTO);
}
