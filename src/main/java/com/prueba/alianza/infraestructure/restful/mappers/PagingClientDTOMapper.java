package com.prueba.alianza.infraestructure.restful.mappers;

import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.domain.models.Paging;
import com.prueba.alianza.infraestructure.restful.dto.response.ListClientDTO;
import com.prueba.alianza.infraestructure.restful.dto.response.PagingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper
public interface PagingClientDTOMapper{

    PagingClientDTOMapper INSTANCE = Mappers.getMapper(PagingClientDTOMapper.class);

    default PagingDTO<ListClientDTO> pagingToPagingDTO(Paging<Client> paging) {
        PagingDTO<ListClientDTO> listClientDTO = new PagingDTO<>();
        listClientDTO.setTotalPages(paging.getTotalPages());
        listClientDTO.setNumber(paging.getNumber());
        listClientDTO.setTotalElements(paging.getTotalElements());
        listClientDTO.setResult(
                paging.getResult()
                        .stream()
                        .map(ListClientDTOMapper.INSTANCE::clientToListClientDTO).collect(Collectors.toList())
        );
        return listClientDTO;
    }

}
