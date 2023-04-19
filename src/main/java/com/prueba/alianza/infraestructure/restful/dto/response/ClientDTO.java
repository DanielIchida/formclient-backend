package com.prueba.alianza.infraestructure.restful.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ClientDTO {
    private int id;
    private String sharedKey;
    private String BusinessId;
    private String email;
    private String phone;
    private LocalDate startDate;
    private LocalDate endDate;
}
