package com.prueba.alianza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class AlianzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlianzaApplication.class, args);
	}

}
