package com.prueba.alianza.infraestructure.database.filter;

import com.prueba.alianza.domain.services.ClientService;
import com.prueba.alianza.infraestructure.database.entities.ClientEntity;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ClientEntitySpecification implements Specification<ClientEntity> {
    private final String name;
    private final String phone;
    private final String email;
    private final String startDate;
    private final String endDate;

    private static final String COMODIN = "%";

    public ClientEntitySpecification(String name, String phone, String email, String startDate, String endDate) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public Predicate toPredicate(Root<ClientEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        if(!StringUtils.isBlank(name)) {
            predicates.add(cb.like(root.get("name"),COMODIN+this.name+COMODIN));
        }
        if(!StringUtils.isBlank(email)) {
            predicates.add(cb.like(root.get("email"),COMODIN+this.email+COMODIN));
        }
        if(!StringUtils.isBlank(phone)) {
            predicates.add(cb.like(root.get("phone"),COMODIN+this.phone+COMODIN));
        }
        if(!StringUtils.isBlank(startDate)) {
            predicates.add(cb.equal(root.get("startDate"), ClientService.localDateFormat(startDate)));
        }
        if(!StringUtils.isBlank(endDate)) {
            predicates.add(cb.equal(root.get("endDate"),ClientService.localDateFormat(endDate)));
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
