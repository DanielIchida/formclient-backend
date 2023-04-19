package com.prueba.alianza.infraestructure.database.dao;

import com.prueba.alianza.infraestructure.database.entities.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ClientDao extends JpaRepository<ClientEntity,Integer> , JpaSpecificationExecutor<ClientEntity> {

    Page<ClientEntity> findAll(Pageable pageable);
    @Query("SELECT c From ClientEntity c WHERE c.email LIKE CONCAT(:email,'@','%')")
    Page<ClientEntity> findAllByEmail(@Param("email") String email, Pageable pageable);
    Page<ClientEntity> findAll(Specification<ClientEntity> specification, Pageable pageable);

}
