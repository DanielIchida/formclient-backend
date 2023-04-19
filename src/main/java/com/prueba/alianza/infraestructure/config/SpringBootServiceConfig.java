package com.prueba.alianza.infraestructure.config;

import com.prueba.alianza.application.repositories.ClientRepository;
import com.prueba.alianza.application.usescases.AddClient;
import com.prueba.alianza.application.usescases.FindAll;
import com.prueba.alianza.application.usescases.SearchAdvanced;
import com.prueba.alianza.application.usescases.SearchBySharedKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootServiceConfig {

    @Bean
    public AddClient addClient(ClientRepository clientRepository) {
        return new AddClient(clientRepository);
    }

    @Bean
    public FindAll findAll(ClientRepository clientRepository) {
        return new FindAll(clientRepository);
    }

    @Bean
    public SearchAdvanced searchAdvanced(ClientRepository clientRepository) {
        return new SearchAdvanced(clientRepository);
    }

    @Bean
    public SearchBySharedKey searchBySharedKey(ClientRepository clientRepository) {
        return new SearchBySharedKey(clientRepository);
    }

}
