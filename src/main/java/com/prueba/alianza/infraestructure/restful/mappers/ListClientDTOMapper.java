package com.prueba.alianza.infraestructure.restful.mappers;

import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.infraestructure.restful.dto.response.ListClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ListClientDTOMapper {

    ListClientDTOMapper INSTANCE = Mappers.getMapper(ListClientDTOMapper.class);

    default ListClientDTO clientToListClientDTO(Client client) {
        ListClientDTO listClientDTO = new ListClientDTO();
        listClientDTO.setBusinessId(client.getBusinessId());
        listClientDTO.setEmail(client.getEmail());
        listClientDTO.setPhone(client.getPhone());
        listClientDTO.setSharedKey(client.getSharedKey());
        listClientDTO.setDateAdd(client.getStartDate());
        return listClientDTO;
    }

}
