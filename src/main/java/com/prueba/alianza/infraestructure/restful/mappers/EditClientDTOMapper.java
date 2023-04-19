package com.prueba.alianza.infraestructure.restful.mappers;

import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.domain.services.ClientService;
import com.prueba.alianza.infraestructure.restful.dto.request.EditClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditClientDTOMapper {

    EditClientDTOMapper INSTANCE = Mappers.getMapper(EditClientDTOMapper.class);

    default Client EditClientDTOToClient(EditClientDTO editClientDTO) {
        Client client = new Client();
        client.setBusinessId(editClientDTO.getName());
        client.setPhone(editClientDTO.getPhone());
        client.setEmail(editClientDTO.getEmail());
        client.setEndDate(ClientService.localDateFormat(editClientDTO.getEndDate()));
        client.setStartDate(ClientService.localDateFormat(editClientDTO.getStartDate()));
        return client;
    }

}
