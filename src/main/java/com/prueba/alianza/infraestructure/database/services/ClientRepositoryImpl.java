package com.prueba.alianza.infraestructure.database.services;

import com.prueba.alianza.application.repositories.ClientRepository;
import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.domain.models.Paging;
import com.prueba.alianza.domain.services.ClientService;
import com.prueba.alianza.infraestructure.database.dao.ClientDao;
import com.prueba.alianza.infraestructure.database.entities.ClientEntity;
import com.prueba.alianza.infraestructure.database.filter.ClientEntitySpecification;
import com.prueba.alianza.infraestructure.database.mappers.ClientEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    public ClientDao clientDao;

    @Override
    public Client add(Client client) {
        ClientEntity newClientEntity = clientDao.save(ClientEntityMapper.INSTANCE.clientEntityToClient(client));
        return ClientEntityMapper.INSTANCE.clientToClientEntity(newClientEntity);
    }

    @Override
    public Paging<Client> findAll(int currentPage, int size) {
        Paging<Client> paging = new Paging<>();
        Page<ClientEntity> clientPage = clientDao.findAll(getPageable(currentPage,size));
        paging.setNumber(clientPage.getNumber());
        getPageClientEntity(paging,clientPage);
        return paging;
    }

    @Override
    public Paging<Client> searchBySharedKey(String sharedKey, int currentPage, int size) {
        Paging<Client> paging = new Paging<>();
        Page<ClientEntity> clientPage = clientDao.findAllByEmail(sharedKey,getPageable(currentPage,size));
        getPageClientEntity(paging,clientPage);
        return paging;
    }

    @Override
    public Paging<Client> searchAdvanced(String name,String phone,String email, String startDate,String endDate, int currentPage, int size) {
        Paging<Client> paging = new Paging<>();
        ClientEntitySpecification clientEntitySpecification = new ClientEntitySpecification(name, phone, email, startDate, endDate);
        Page<ClientEntity> clientPage = clientDao.findAll(clientEntitySpecification, getPageable(currentPage,size));
        getPageClientEntity(paging,clientPage);
        return paging;
    }


    private Pageable getPageable(int currentPage, int size) {
        return  PageRequest.of(currentPage,size);
    }

    private void getPageClientEntity(Paging<Client> paging,Page<ClientEntity> clientPage ) {
        paging.setNumber(clientPage.getNumber());
        paging.setTotalPages(clientPage.getTotalPages());
        paging.setTotalElements(clientPage.getTotalElements());
        paging.setResult(
                clientPage.
                        getContent().
                        stream()
                        .map(ClientEntityMapper.INSTANCE::clientToClientEntity)
                        .collect(Collectors.toList()));
    }

}
