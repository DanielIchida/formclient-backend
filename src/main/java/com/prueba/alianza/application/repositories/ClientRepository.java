package com.prueba.alianza.application.repositories;

import com.prueba.alianza.domain.models.Client;
import com.prueba.alianza.domain.models.Paging;

import java.util.List;

public interface ClientRepository {
    Client add(Client client);
    Paging<Client> findAll(int currentPage, int size);
    Paging<Client> searchBySharedKey(String sharedKey,int currentPage,int size);
    Paging<Client> searchAdvanced(String name,String phone,String email, String startDate,String endDate,int currentPage,int size);
}
